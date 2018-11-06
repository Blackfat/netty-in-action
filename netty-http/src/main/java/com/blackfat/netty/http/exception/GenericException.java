package com.blackfat.netty.http.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-15:46
 */
@Data
public class GenericException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    protected   String errorCode;
    protected  String errorMessage;

    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(Exception oriEx) {
        super(oriEx);
    }

    public GenericException(Exception oriEx, String message) {
        super(message, oriEx);
    }

    public GenericException(Throwable oriEx) {
        super(oriEx);
    }

    public GenericException(String message, Exception oriEx) {
        super(message, oriEx);
    }

    public GenericException(String message, Throwable oriEx) {
        super(message, oriEx);
    }

}
