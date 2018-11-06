package com.blackfat.netty.protocol;

import lombok.Data;

import java.util.List;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:11
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
