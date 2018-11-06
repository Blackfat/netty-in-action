package com.blackfat.netty.server.handler;

import com.blackfat.netty.protocol.LoginRequestPacket;
import com.blackfat.netty.protocol.LogoutRequestPacket;
import com.blackfat.netty.protocol.LogoutResponsePacket;
import com.blackfat.netty.session.Session;
import com.blackfat.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:43
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.writeAndFlush(logoutResponsePacket);
    }
}
