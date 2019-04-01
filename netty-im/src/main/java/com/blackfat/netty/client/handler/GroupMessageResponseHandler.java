package com.blackfat.netty.client.handler;

import com.blackfat.netty.protocol.GroupMessageResponsePacket;
import com.blackfat.netty.session.Session;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-13:33
 */
@ChannelHandler.Sharable
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket>  {

    public static final  GroupMessageResponseHandler INSTANCE = new GroupMessageResponseHandler();

    private GroupMessageResponseHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        String fromGroupId = groupMessageResponsePacket.getFromGroupId();
        Session fromUser = groupMessageResponsePacket.getFromUser();
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + groupMessageResponsePacket.getMessage());
    }
}
