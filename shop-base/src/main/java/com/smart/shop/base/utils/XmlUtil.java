package com.smart.shop.base.utils;

import org.dom4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;


public class XmlUtil {

    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);


    /**
     * 替换所有的指定名称元素的文本为指定值
     * <p/>
     * 如果同时需要替换XML中多个名称的元素的文本，使用 {@link #replaceAllNamedElementsText}
     *
     * @param xml   XML格式字符串
     * @param name  元素的名称
     * @param value 新的文本
     *
     * @return 进行替换后的XML格式字符串
     * @throws DocumentException DocumentException
     */
    private static String replaceNamedElementsText(String xml, String name, String value) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        replaceNamedElementsText(doc, name, value);
        return doc.asXML();
    }

    /**
     * 替换所有的指定名称元素的文本为指定值（一次替换多个名称的元素）
     *
     * @param xml        XML格式字符串
     * @param nameValues <code>key</code> 代表要被替换文本的元素的名称，<code>value</code> 代表新的文本
     *
     * @return 进行替换后的XML格式字符串
     * @throws DocumentException DocumentException
     */
    public static String replaceAllNamedElementsText(String xml, Map<String, String> nameValues) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        Set<String> names = nameValues.keySet();
        for (String name : names) {
            String value = nameValues.get(name);
            replaceNamedElementsText(doc, name, value);
        }

        return doc.asXML();
    }

    /**
     * 替换所有的指定名称元素的文本为指定值（一次替换多个名称的元素）
     *
     * @param xml        XML格式字符串
     * @param nameValues <code>nameValues[i][0]</code> 代表要被替换文本的元素的名称；
     *                   <code>nameValues[i][1]</code> 代表新的文本
     *
     * @return 进行替换后的XML格式字符串
     * @throws DocumentException DocumentException
     */
    public static String replaceAllNamedElementsText(String xml, String[][] nameValues) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);

        for (String[] pathValue : nameValues) {
            replaceNamedElementsText(doc, pathValue[0], pathValue[1]);
        }

        return doc.asXML();
    }

    /**
     * 删除所有指定名称的元素（一次删除多个名称的元素）
     *
     * @param xml   XML格式字符串
     * @param names 要被删除的所有元素的名称
     *
     * @return 进行删除后的XML格式字符串（如果是格式化的，则会有空白行）
     * @throws DocumentException DocumentException
     */
    @SuppressWarnings("unchecked")
    public static String deleteAllNamedElements(String xml, String[] names) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);

        for (String path : names) {
            XPath x = createXPathWithNamespace(doc, path);
            List<Node> nodes = x.selectNodes(doc);
            for (Node node : nodes) {
                node.detach();
                if (logger.isDebugEnabled())
                    logger.debug("Node [" + node + "] has been removed.");
            }
        }

        return doc.asXML();
    }


    ///////////////////////////////////////////////////////////////////////////
    // <<私有辅助方法>>

    /**
     * 替换所有的指定名称元素的文本为指定值
     *
     * @param doc   <code>{@link org.dom4j.Document}</code> 对象
     * @param name  元素的名称
     * @param value 新的文本
     */
    @SuppressWarnings("unchecked")
    private static void replaceNamedElementsText(Document doc, String name, String value) {
        XPath x = createXPathWithNamespace(doc, name);
        List<Node> nodes = x.selectNodes(doc);
        for (Node node : nodes) {
            node.setText(value);
            if (logger.isDebugEnabled())
                logger.debug("Node [" + node + "] 's text has been replaced with [" + value + "]");
        }
    }

    /**
     * 获取匹配指定元素的 XPath
     *
     * @param doc         <code>{@link org.dom4j.Document}</code> 对象
     * @param elementName 元素名称
     *
     * @return 匹配指定元素的 XPath
     */
    private static XPath createXPathWithNamespace(Document doc, String elementName) {
        HashMap<String, String> nsMap = new HashMap<String, String>();

        String defaultNamespace = doc.getRootElement().getNamespaceURI();
        nsMap.put("default", defaultNamespace);

        XPath xPath = doc.createXPath("//default:" + elementName);
        xPath.setNamespaceURIs(nsMap);

        return xPath;
    }


    ///////////////////////////////////////////////////////////////////////////
    // <<测试方法>>

    public static void main(String[] args) throws DocumentException, IOException {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<MasMessage xmlns=\"http://www.99bill.com/mas_cnp_merchant_interface\">\n" +
                "  <TxnMsgContent>\n" +
                "    <txnType>PUR</txnType>\n" +
                "    <interactiveStatus>TR1</interactiveStatus>\n" +
                "    <cardNo>4380880000000007</cardNo>\n" +
                "    <cardNo>4380880000000008</cardNo>\n" +
                "    <cardNo><cvv2>222</cvv2></cardNo>\n" +
                "    <expiredDate>1111</expiredDate>\n" +
                "    <cvv2>222</cvv2>\n" +
                "    <cvv2><cardNo>4380880000000008</cardNo></cvv2>\n" +
                "  </TxnMsgContent>\n" +
                "</MasMessage>";

        System.out.println("===========================================================");
        System.out.println("xml = " + xml);
        System.out.println("===========================================================");

        String[][] nameValues = new String[3][2];
        nameValues[0] = new String[]{"cardNo", "9999****9999"};
        nameValues[1] = new String[]{"expiredDate", "**99"};
        nameValues[2] = new String[]{"cvv2", "***"};

        String replace1 = replaceAllNamedElementsText(xml, nameValues);
        System.out.println("===========================================================");
        System.out.println("replace1 = " + replace1);
        System.out.println("===========================================================");

        Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put("cardNo", "8888****8888");
        keyValues.put("expiredDate", "**88");
        keyValues.put("cvv2", "***");
        String replace2 = replaceAllNamedElementsText(xml, keyValues);
        System.out.println("===========================================================");
        System.out.println("replace2 = " + replace2);
        System.out.println("===========================================================");

        String replace3 = replaceNamedElementsText(xml, "txnType", "OK");
        System.out.println("===========================================================");
        System.out.println("replace3 = " + replace3);
        System.out.println("===========================================================");

        String delete = deleteAllNamedElements(xml, new String[]{"cardNo", "cvv2"});
        System.out.println("===========================================================");
        System.out.println("delete = " + delete);
        System.out.println("===========================================================");
    }


}
