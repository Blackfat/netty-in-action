package com.blackfat.netty.codec;

import com.blackfat.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author wangfeiyang
 * @desc   ChannelInboundHandlerAdapter
 * @create 2018/11/2-9:58
 */
public class PacketDecoder extends ByteToMessageDecoder {
    /**
     * ByteBuf默认为堆外内存，需要手动释放，ByteToMessageDecoder已经维护了引用
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.err.println("ByteBuf："+in.isDirect());
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
