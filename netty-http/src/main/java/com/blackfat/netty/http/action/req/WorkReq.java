package com.blackfat.netty.http.action.req;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-17:29
 */
@Data
public class WorkReq {

    private Integer timeStamp;


    @Override
    public String toString() {
        return "WorkReq{" +
                "timeStamp=" + timeStamp +
                '}';
    }
}
