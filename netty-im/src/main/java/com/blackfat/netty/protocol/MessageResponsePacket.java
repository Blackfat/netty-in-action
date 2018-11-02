package com.blackfat.netty.protocol;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-15:56
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
