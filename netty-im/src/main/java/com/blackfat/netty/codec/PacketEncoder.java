package com.blackfat.netty.codec;

import com.blackfat.netty.protocol.Packet;
import com.blackfat.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wangfeiyang
 * @desc   ChannelOutboundHandlerAdapter
 * @create 2018/11/2-10:11
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
