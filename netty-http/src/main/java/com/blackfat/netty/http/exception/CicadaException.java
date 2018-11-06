package com.blackfat.netty.http.exception;

import com.blackfat.netty.http.enums.StatusEnum;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-15:50
 */
public class CicadaException extends  GenericException {

    public CicadaException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CicadaException(Exception e, String errorCode, String errorMessage) {
        super(e, errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CicadaException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public CicadaException(StatusEnum statusEnum) {
        super(statusEnum.getMessage());
        this.errorMessage = statusEnum.message();
        this.errorCode = statusEnum.getCode();
    }

    public CicadaException(StatusEnum statusEnum, String message) {
        super(message);
        this.errorMessage = message;
        this.errorCode = statusEnum.getCode();
    }

    public CicadaException(Exception oriEx) {
        super(oriEx);
    }

    public CicadaException(Throwable oriEx) {
        super(oriEx);
    }

    public CicadaException(String message, Exception oriEx) {
        super(message, oriEx);
        this.errorMessage = message;
    }

    public CicadaException(String message, Throwable oriEx) {
        super(message, oriEx);
        this.errorMessage = message;
    }
}
