package com.smart.shop.base.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 获取本地和服务器网络IP地址
 * @author wangyu
 *
 */
public class GetLocalServerIP {
	private static String LocalIP = null;  
    private static InetAddress ServerIP = null;  
    private GetLocalServerIP(){}
    /**
     * 取得本机IP地址  
     * @return
     */
    public static String catchLocalIP()  
    {  
        try   
        {  
            LocalIP = InetAddress.getLocalHost().getHostAddress();  
        } catch (UnknownHostException e)   
        {  
        	 System.out.println(e.getMessage());  
        }  
        return LocalIP;  
    }  
    /**
     * 取得服务器网络地址  
     * @param www 域名网址 如 "www.sina.com.cn"
     * @return
     */
    public static InetAddress catchServerIP(String www)  
    {  
        try {  
            ServerIP = InetAddress.getByName(www);  
            //取得www.sina.com.cn的IP地址  
        } catch (UnknownHostException e)   
        {  
            System.out.println(e.getMessage());  
        }  
        return ServerIP;  
    }  
}
