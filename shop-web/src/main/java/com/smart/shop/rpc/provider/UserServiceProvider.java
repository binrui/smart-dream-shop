package com.smart.shop.rpc.provider;

import com.alibaba.dubbo.config.annotation.Service;
/**
 * 用户服务提供者
 * @author lijinfeng
 * @time 2016-02-26
 * @remark 用户服务信息
 */
@Service
public class UserServiceProvider {
	
	public String sayHello(String name){
		return "Hello,"+name.toUpperCase();
	}
}
