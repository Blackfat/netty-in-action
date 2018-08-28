package com.blackfat.netty.client;

import com.blackfat.netty.client.encode.HeartbeatEncode;
import com.blackfat.netty.client.handle.HeartBeatClientHandle;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/28-13:49
 */
public class CustomerHandleInitializer extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                //10 秒没发送消息 将IdleStateHandler 添加到 ChannelPipeline 中
                .addLast(new IdleStateHandler(0,10,0))
                .addLast(new HeartbeatEncode())
                .addLast(new HeartBeatClientHandle());
    }
}
