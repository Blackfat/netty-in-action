package com.blackfat.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/17-13:53
 */
public class NettyTelnetInitializer extends ChannelInitializer<SocketChannel> {

    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipeline = channel.pipeline();

        // 解决TCP数据包拆包粘包问题
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 添加编码和解码的类
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);

        // 添加处理业务的类
        pipeline.addLast(new NettyTelnetHandler());


    }
}
