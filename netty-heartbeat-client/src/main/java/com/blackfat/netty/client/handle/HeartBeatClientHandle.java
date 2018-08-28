package com.blackfat.netty.client.handle;

import com.blackfat.netty.client.util.SpringContextHolder;
import com.blackfat.netty.common.pojo.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/28-10:25
 */
public class HeartBeatClientHandle extends SimpleChannelInboundHandler<ByteBuf>{
    
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatClientHandle.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       if(evt instanceof IdleStateEvent){
           IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
           if(idleStateEvent.state() == IdleState.WRITER_IDLE){
               logger.info("已经10秒没有发送消息了！");
               CustomProtocol heartBeat = SpringContextHolder.getBean("heartBeat");
               ctx.writeAndFlush(heartBeat).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
           }
       }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        logger.info("客户端收到消息={}",byteBuf.toString(CharsetUtil.UTF_8)) ;
    }
}
