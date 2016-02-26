package com.smart.shop.order;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {

	public String sayHello(String name){
		return "Hello,"+name;
	}
	
}
