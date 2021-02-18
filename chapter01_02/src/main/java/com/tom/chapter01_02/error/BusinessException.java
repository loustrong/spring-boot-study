package com.tom.chapter01_02.error;

/**
 * BusinessException
 *
 * @author Tom on 2021/2/17
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}

    public BusinessException(String message) {
        super(message);
    }
}

