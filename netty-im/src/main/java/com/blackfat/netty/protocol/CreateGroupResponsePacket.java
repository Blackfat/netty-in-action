package com.blackfat.netty.protocol;

import lombok.Data;

import java.util.List;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:12
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
