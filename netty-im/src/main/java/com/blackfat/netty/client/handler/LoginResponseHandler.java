package com.blackfat.netty.client.handler;

import com.blackfat.netty.protocol.LoginRequestPacket;
import com.blackfat.netty.protocol.LoginResponsePacket;
import com.blackfat.netty.protocol.PacketCodeC;
import com.blackfat.netty.session.Session;
import com.blackfat.netty.util.LoginUtil;
import com.blackfat.netty.util.SessionUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/2-10:17
 */
@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    public static final LoginResponseHandler INSTANCE = new LoginResponseHandler();

    private LoginResponseHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            System.out.println("[" + userName + "]登录成功，userId 为: " + loginResponsePacket.getUserId());
            // 客户端的channle和服务端的channel不是用一个，需要分别处理
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
        } else {
            System.out.println("[" + userName + "]登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭");
    }
}
