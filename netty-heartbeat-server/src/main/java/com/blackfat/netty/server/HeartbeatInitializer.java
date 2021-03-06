package com.blackfat.netty.server;

import com.blackfat.netty.server.decode.HeartbeatDecode;
import com.blackfat.netty.server.handle.HeartBeatSimpleHandle;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/28-17:29
 */
public class HeartbeatInitializer extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                //五秒没有收到消息 将IdleStateHandler 添加到 ChannelPipeline 中
                .addLast(new IdleStateHandler(5, 0, 0))
                // 将消息解析为字符串
                .addLast(new LineBasedFrameDecoder(1024))
                .addLast(new StringDecoder())
                // 自定义消息解析
//                .addLast(new HeartbeatDecode())
                .addLast(new HeartBeatSimpleHandle());
    }
}
