package com.smart.shop.base.threadlocal;

import java.util.Map;

/**
 * 当前线程工具类
 * @description
 * @author hexizheng
 * *@deprecated  service maybe be deployed separately.
 */

public class ThreadLocalUtils {
	
	public static final String CURRENT_USER = "THREAD_LOCAL_CURRENT_USER";
	public static final String USER = "USER_OBJECT";

	/**
	 * 保持当前线程独有信息的对象
	 */
	@SuppressWarnings("unused")
	private static final ThreadLocal<Map<Object, Object>> threadLocal = new ThreadLocal<Map<Object, Object>>();

	/**
	 * 往当前线程中存放信息
	 * 
	 * @param key
	 * @param value
	 */
//	public static void setValue(Object key, Object value) {
//		Map<Object, Object> threadLocalValueMap = threadLocal.get();
//		if (threadLocalValueMap == null) {
//			threadLocalValueMap = new HashMap<Object, Object>();
//			threadLocal.set(threadLocalValueMap);
//		}
//		threadLocalValueMap.put(key, value);
//	}
//	public static void setUser( Object value) {
//		Map<Object, Object> threadLocalValueMap = threadLocal.get();
//		if (threadLocalValueMap == null) {
//			threadLocalValueMap = new HashMap<Object, Object>();
//			threadLocal.set(threadLocalValueMap);
//		}
//		threadLocalValueMap.put(USER, value);
//	}
//
//	/**
//	 * 从当前线程中取得信息
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public static Object getValue(Object key) {
//		Map<Object, Object> threadLocalValueMap = threadLocal.get();
//		if (threadLocalValueMap == null) {
//			return null;
//		} else {
//			return threadLocalValueMap.get(key);
//		}
//	}
//	public static <T> T getUser( Class<T> valueType) {
//		Map<Object, Object> threadLocalValueMap = threadLocal.get();
//		if (threadLocalValueMap == null) {
//			return null;
//		} else {
//			return (T)threadLocalValueMap.get(USER);
//		}
//	}
//
//	/**
//	 * 取得当前用户名
//	 * 
//	 * @return
//	 */
//	public static String getUserName() {
//		CurrentUser user = getCurrentUser();
//		if(user == null){
//	        return null; 
//	    }
//		return user.getUserName();
//	}
//
//	/**
//	 * 取得当前用户编号
//	 * 
//	 * @return
//	 */
//	public static Long getUserId() {
//		CurrentUser user = getCurrentUser();
//		if(user == null){
//	        return null; 
//	    }
//		return user.getUserId();
//	}
//
//	
//	/**
//	 * 取得当前用户IP
//	 * 
//	 * @return
//	 */
//	public static String getUserIP() {
//		CurrentUser user = getCurrentUser();
//		if(user == null){
//	        return null; 
//	    }
//		return user.getIp();
//	}
//	
//	
//	/**
//	 * @param 
//	 */
//	public static void setCurrentUser(CurrentUser user) {
//		setValue(CURRENT_USER, user);
//	}
//
//	/**
//	 * @param 
//	 */
//	public static CurrentUser getCurrentUser() {
//		return (CurrentUser) getValue(CURRENT_USER);
//	}
//	
	
}
