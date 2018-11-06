package com.blackfat.netty.protocol;

import com.blackfat.netty.session.Session;
import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-11:49
 */
@Data
public class GroupMessageResponsePacket  extends Packet{

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
