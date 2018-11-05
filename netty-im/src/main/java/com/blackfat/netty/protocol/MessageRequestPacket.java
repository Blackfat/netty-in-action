package com.blackfat.netty.protocol;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc   客户端发送到服务端请求
 * @create 2018/11/1-15:55
 */
@Data
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    public MessageRequestPacket(){

    }

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
