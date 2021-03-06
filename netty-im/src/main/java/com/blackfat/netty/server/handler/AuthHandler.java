package com.blackfat.netty.server.handler;

import com.blackfat.netty.util.LoginUtil;
import com.blackfat.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import sun.rmi.runtime.Log;

/**
 * @author wangfeiyang
 * @desc 身份校验
 * @create 2018/11/5-9:29
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

    public static final AuthHandler INSTANCE = new AuthHandler();

    private AuthHandler(){

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       if(!SessionUtil.hasLogin(ctx.channel())){
           ctx.channel().close();
       }else{
           // 验证通过即可删除后序验证
           ctx.pipeline().remove(this);
           super.channelRead(ctx, msg);
       }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
       if(SessionUtil.hasLogin(ctx.channel())){
           System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
       }else{
           System.out.println("无登录验证，强制关闭连接!");
       }
    }
}
