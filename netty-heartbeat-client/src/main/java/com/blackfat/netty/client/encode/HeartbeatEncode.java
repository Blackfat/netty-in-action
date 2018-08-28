package com.blackfat.netty.client.encode;

import com.blackfat.netty.common.pojo.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wangfeiyang
 * @desc 编码
 * @create 2018/8/28-10:05
 */
public class HeartbeatEncode extends MessageToByteEncoder<CustomProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CustomProtocol customProtocol, ByteBuf byteBuf) throws Exception {
        // 前八个字节为header，其他都是body
        byteBuf.writeLong(customProtocol.getId());
        byteBuf.writeBytes(customProtocol.getContent().getBytes());
    }
}
