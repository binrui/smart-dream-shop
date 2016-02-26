package com.smart.shop.base.exception;

import org.springframework.util.StringUtils;

/**
 * 业务异常
 * @author lijinfeng
 * @time 2016-02-26
 * 
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -5995434434196299378L;

	private String buisinessCode;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}
	public BusinessException(String message,Long id) {
		super("id=["+id+"]"+message);
	}

	public BusinessException(String code, String message) {
		super(message);
		buisinessCode = code;
	}
	public BusinessException(ReturnCode returnCode) {
		super(returnCode.getMessage());
		buisinessCode = returnCode.getCode();
	}

	public BusinessException(String message, Throwable t) {
		super(message, t);
	}

	public BusinessException(String code, String message, Throwable t) {
		super(message, t);
		buisinessCode = code;
	}
	public BusinessException(ReturnCode returnCode, Throwable t) {
		super(returnCode.getMessage(), t);
		buisinessCode = returnCode.getCode();
	}

	public String getBuisinessCode() {
		return buisinessCode;
	}
	public boolean isExistCode(){
		if(StringUtils.isEmpty(buisinessCode)){
			return false;
		}else{
			return true;
		}
	}
	
	public String getDisplayMessage(){
		if(isExistCode()){
			return getMessage();
		}
		return "系统繁忙，请稍后重试。";
	}
}
