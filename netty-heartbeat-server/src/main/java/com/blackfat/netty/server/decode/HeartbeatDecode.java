package com.blackfat.netty.server.decode;

import com.blackfat.netty.common.pojo.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author wangfeiyang
 * @desc 解码
 * @create 2018/8/28-10:11
 */
public class HeartbeatDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        long id = byteBuf.readLong();
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String content = new String(bytes);

        CustomProtocol protocol = new CustomProtocol(id, content);
        list.add(protocol);
    }
}
