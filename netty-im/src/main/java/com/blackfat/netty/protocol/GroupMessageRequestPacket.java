package com.blackfat.netty.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-11:48
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends   Packet {

    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
