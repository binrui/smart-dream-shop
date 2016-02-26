package com.smart.shop.base.exception;

import java.io.Serializable;

/**
 * 乐观锁异常，并发更新数据库记录，出现脏数据时抛出
 * User: hexizheng@163.com
 * Date: 14-7-23
 * Time: 下午10:13
 */
@SuppressWarnings("serial")
public class OptimisticLockException extends RuntimeException implements Serializable {


    /**
     * 获取基本异常信息
     *
     */
    public OptimisticLockException() {
        super();
    }

    /**
     * 获取基本异常信息
     *
     * @param message
     */
    public OptimisticLockException(String message) {
        super(message);
        setErrorMessage(message);
    }

    /**
     * 获取基本异常信息
     *
     * @param message
     * @param t
     */
    public OptimisticLockException(String message, Exception t) {
        super(message, t);
        setErrorMessage(message);
    }

    /**
     * 获取基本异常信息
     *
     * @param t
     */
    public OptimisticLockException(Exception t) {
        super(t);
        setErrorMessage(t.getMessage());
    }

    /**
     * 获取基本异常信息
     *
     * @param errorId
     * @param message
     */
    public OptimisticLockException(String errorId, String message) {
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
