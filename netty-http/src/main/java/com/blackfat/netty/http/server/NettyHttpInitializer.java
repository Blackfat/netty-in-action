package com.blackfat.netty.http.server;

import com.blackfat.netty.http.server.NettyHttpHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/3-14:00
 */
public class NettyHttpInitializer extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new HttpRequestDecoder())
                .addLast(new HttpResponseEncoder())
                .addLast(new NettyHttpHandler())
                .addLast("logging", new LoggingHandler(LogLevel.INFO));
    }
}
