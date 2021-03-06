package com.blackfat.netty.protocol;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-14:22
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
