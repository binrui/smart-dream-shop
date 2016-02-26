package com.smart.shop.base.jstl;

import com.smart.shop.base.utils.NumberUtils;

/**
 * @author Administrator
 * @time 2016-02-26
 */
public class AmountTransfer {


    public static String display(Integer amount){
        if(amount==null){
            return "";
        }
        return NumberUtils.leftMove(amount.toString(),2);
    }
}
