package com.blackfat.netty.protocol;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-15:28
 */
@Data
public class LoginResponsePacket extends Packet {

    private String userId;

    private String userName;

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
