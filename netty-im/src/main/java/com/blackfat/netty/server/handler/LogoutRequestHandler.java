package com.blackfat.netty.server.handler;

import com.blackfat.netty.protocol.LoginRequestPacket;
import com.blackfat.netty.protocol.LogoutRequestPacket;
import com.blackfat.netty.protocol.LogoutResponsePacket;
import com.blackfat.netty.session.Session;
import com.blackfat.netty.util.SessionUtil;
import io.netty.channel.*;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:43
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    private LogoutRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        /*
        * ctx.channel().writeAndFlush()
        * 从 pipeline 链中的最后一个 outBound 类型的 handler 开始，把对象往前进行传播
        * ctx.writeAndFlush
        * 从 pipeline 链中的当前节点开始往前找到第一个 outBound 类型的 handler 把对象往前进行传播
        *
        * */
        ctx.writeAndFlush(logoutResponsePacket);
    }
}
