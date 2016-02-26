package com.smart.shop.base.exception;

import java.io.Serializable;
/**
 * 用户没有登录异常
 * @author lijinfeng
 * @time 2016-02-26
 */
public class UserNotLoginException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8345931433388972999L;

	/**
	 * 获取基本异常信息
	 * 
	 */
	public UserNotLoginException() {
		super();
	}

	/**
	 * 获取基本异常信息
	 * 
	 * @param message
	 */
	public UserNotLoginException(String message) {
		super(message);
		setErrorMessage(message);
	}

	/**
	 * 获取基本异常信息
	 * 
	 * @param message
	 * @param t
	 */
	public UserNotLoginException(String message, Exception t) {
		super(message, t);
		setErrorMessage(message);
	}

	/**
	 * 获取基本异常信息
	 * 
	 * @param t
	 */
	public UserNotLoginException(Exception t) {
		super(t);
		setErrorMessage(t.getMessage());
	}

	/**
	 * 获取基本异常信息
	 * 
	 * @param errorId
	 * @param message
	 */
	public UserNotLoginException(String errorId, String message) {
		super(message, new Exception(errorId));
		setErrorId(errorId);
		setErrorMessage(message);
		System.out.println(errorId + "++++++++++++++++++++" + message);
	}

	private String errorId = "-1";
	private String errorMessage;

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
