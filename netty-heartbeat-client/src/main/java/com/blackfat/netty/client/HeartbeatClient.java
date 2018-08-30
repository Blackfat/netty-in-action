package com.blackfat.netty.client;

import com.alibaba.fastjson.JSON;
import com.blackfat.netty.common.pojo.CustomProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/28-13:52
 */
@Component
public class HeartbeatClient {

    private static final Logger logger = LoggerFactory.getLogger(HeartbeatClient.class);

    private EventLoopGroup group = new NioEventLoopGroup();
    @Value("${netty.server.port}")
    private int nettyPort;
    @Value("${netty.server.host}")
    private String host;
    private SocketChannel channel;


    @PostConstruct
    public void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new CustomerHandleInitializer())
        ;
        ChannelFuture future = bootstrap.connect(host, nettyPort).sync();
        if (future.isSuccess()) {
            logger.info("启动 Netty 成功");
        }
        channel = (SocketChannel) future.channel();
    }

    /**
     * 发送消息
     *
     * @param customProtocol
     */
    public void sendMsg(CustomProtocol customProtocol) {
        ChannelFuture future = channel.writeAndFlush(customProtocol);
        future.addListener((ChannelFutureListener) channelFuture ->
                logger.info("客户端手动发消息成功={}", JSON.toJSONString(customProtocol)));

    }

    /**
     * 发送消息字符串
     *
     * @param msg
     */
    public void sendStringMsg(String msg) {
        ByteBuf message = Unpooled.buffer(msg.getBytes().length) ;
        message.writeBytes(msg.getBytes()) ;
        ChannelFuture future = channel.writeAndFlush(message);
        future.addListener((ChannelFutureListener) channelFuture ->
                logger.info("客户端手动发消息成功={}", msg));

    }

}
