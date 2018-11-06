package com.blackfat.netty.protocol;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:08
 */
public class LogoutRequestPacket extends  Packet {

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_REQUEST;
    }
}
