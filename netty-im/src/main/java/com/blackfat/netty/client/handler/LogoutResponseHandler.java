package com.blackfat.netty.client.handler;

import com.blackfat.netty.protocol.LogoutResponsePacket;
import com.blackfat.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:47
 */
@ChannelHandler.Sharable
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    public static final LogoutResponseHandler INSTANCE = new LogoutResponseHandler();

    private  LogoutResponseHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
