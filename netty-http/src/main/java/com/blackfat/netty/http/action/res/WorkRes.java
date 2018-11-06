package com.blackfat.netty.http.action.res;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-17:28
 */
@Data
public class WorkRes<T> {

    private String code;

    private String message;

    private T dataBody;
}
