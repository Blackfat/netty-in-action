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

    Byte LOGOUT_REQUEST = 5;

    Byte LOGOUT_RESPONSE = 6;

    Byte CREATE_GROUP_REQUEST = 7;

    Byte CREATE_GROUP_RESPONSE = 8;

    Byte GROUP_MESSAGE_REQUEST = 15;

    Byte GROUP_MESSAGE_RESPONSE = 16;
}
