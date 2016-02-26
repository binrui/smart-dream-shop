package com.smart.shop.base.databind;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import com.smart.shop.base.utils.StringUtils;

public class MethodParamUtils {

	private static LocalVariableTableParameterNameDiscoverer discover =new LocalVariableTableParameterNameDiscoverer();
//	public Map<String,Class> getMethodParamNameTypeMap(Method method){
//		Map map = new HashMap();
//		
//		String[] params = discover.getParameterNames(method);
//		Class[] classes = method.getParameterTypes();
//		for()
//		return map;
//	}
	
	@SuppressWarnings("rawtypes")
	public static Object[] getArgObjects(Map<String,String> paramValueMap,Method method){
		String[] params = discover.getParameterNames(method);
		Class[] classes = method.getParameterTypes();
		Object[] paramObjects = new Object[params.length];
		for(int i=0;i<params.length;i++){
			String paramName = params[i];
			Class clazz = classes[i];
			String value = paramValueMap.get(paramName);
			if(String.class == clazz){
				paramObjects[i] = paramValueMap.get(paramName);			
					
			}else if(Long.class == clazz){
				if(StringUtils.isNotEmpty(value)){
					paramObjects[i] = paramValueMap.get(Long.parseLong(value));
				}
			}else if(Integer.class == clazz){
				if(StringUtils.isNotEmpty(value)){
					paramObjects[i] = paramValueMap.get(Integer.parseInt(paramValueMap.get(paramName)));
				}
			}else if(Short.class == clazz){
				if(StringUtils.isNotEmpty(value)){
					paramObjects[i] = paramValueMap.get(Short.parseShort(paramValueMap.get(paramName)));
				}
			}else if(Map.class == clazz){
				
			}else if(List.class == clazz){
				
			}else{
				
			}
		}
		
		return paramObjects;
	}
	
	
	
	
	  
	
	
    public static void main(String[] args) {  
    	Map<String,String> paramValueMap = new HashMap<String,String>();
    	Method method = Test.class.getMethods()[0] ;
    	Object[] o = MethodParamUtils.getArgObjects(paramValueMap,method);
    	try {
    		method.invoke(new Test() , o);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}

class Test{
	
	public void tests(String param1, Long sdfsdf,String pa3) {  
        System.out.print(param1);  
        System.out.print(sdfsdf);  
        System.out.print(pa3);  
    }
}
