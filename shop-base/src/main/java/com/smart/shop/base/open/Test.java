package com.smart.shop.base.open;
import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

@SuppressWarnings("rawtypes")
public class Test {  

	public String concatString(Map map,String param1, Long sdfsdf,Object oo,String param2) {  
        return param1 + param2;  
    }  
	
    public static void main(String[] args) {  
	    LocalVariableTableParameterNameDiscoverer u =   
	            new LocalVariableTableParameterNameDiscoverer();  
	    Test demo = new Test();  
	        Method[] methods = demo.getClass().getDeclaredMethods();  
	        String[] params = u.getParameterNames(methods[0]);  
	        
	        for (int i = 0; i < params.length; i++) {  
	            System.out.println(params[i]);  
	        }  
	        for(Class classs:methods[0].getParameterTypes()){
	        	System.out.println(classs.getName());
	        }
    }
}  