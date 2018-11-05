package com.blackfat.netty.protocol;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc   登录请求
 * @create 2018/11/1-14:23
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userName;

    private String password;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
