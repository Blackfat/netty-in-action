package com.blackfat.netty.common.base;

import java.io.Serializable;

/**
 * @author wangfeiyang
 * @desc   基础结果集实体
 * @create 2018/5/21-11:16
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SUCCESS_CODE = "0000";

    public static final String SUCCESS_MSG = "";

    /**
     * 错误码.
     */
    public static final String ERROR_CODE = "500";

    /**
     * 错误信息.
     */
    public static final String ERROR_MESSAGE = "内部异常";

    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 错误相关信息
     */
    private String errMsg;


    /**
     * 返回结果对象
     */
    private T model;

    private BaseResult() {
    }

    private BaseResult(String statusCode, String errMsg, T model) {
        this.statusCode = statusCode;
        this.model = model;
        this.errMsg = errMsg;
    }

    /**
     * 创建成功返回值
     *
     * @param object
     *            需要包装的结果
     * @param <T>
     *            包装的结果类型
     * @return Result结果对象
     */
    public static <T> BaseResult<T> succeed(T object) {
        return new BaseResult<T>(SUCCESS_CODE, SUCCESS_MSG, object);
    }

    /**
     * 创建成功返回值
     *
     * @param message
     *            成功信息
     * @param object
     *            需要包装的结果
     * @return Result结果对象
     */
    public static <T> BaseResult<T> succeed(String message, T object) {
        return new BaseResult<T>(SUCCESS_CODE, message, object);
    }

    /**
     * 创建失败返回值
     *
     * @param errCode
     *            此处为错误码(不能为{@value #SUCCESS_CODE})
     * @return Result结果对象
     */
    public static <T> BaseResult<T> fail(String errCode, String message) {
        return new BaseResult<T>(errCode, message, null);
    }

    /**
     * 创建失败返回值
     *
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> fail(){
        return new BaseResult<T>(ERROR_CODE,ERROR_MESSAGE,null);
    }

    /**
     * 创建失败返回值
     *
     * @param errCode
     *            此处为错误码(不能为{@value #SUCCESS_CODE})
     * @param errMsg
     *            异常信息
     * @param object
     *            需要包装的结果
     * @return Result结果对象
     */
    public static <T> BaseResult<T> fail(String errCode, String errMsg, T object) {
        return new BaseResult<T>(errCode, errMsg, object);
    }

    /**
     * 结果是否成功，根据状态码是否等于{@value #SUCCESS_CODE}来判断
     *
     * @return 是否成功布尔值
     */
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(statusCode);
    }

    /**
     * 结果是否成功，根据状态码是否等于{@value #SUCCESS_CODE}且model不为空来判断
     *
     * @return 是否成功布尔值
     */
    public boolean isSuccessful() {
        return isSuccess() && model != null;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }


    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Result [statusCode=%s, errMsg=%s, object=%s]",
                statusCode, errMsg, model);
    }



}
