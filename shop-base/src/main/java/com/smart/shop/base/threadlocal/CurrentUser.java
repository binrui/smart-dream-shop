package com.smart.shop.base.threadlocal;
/**
 * 当前登录用户
 * @author Administrator
 *
 */
public class CurrentUser {

	private long userId;
	
	private String userName;
	
	private String ip;


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
