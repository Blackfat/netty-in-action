package com.blackfat.netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/3-14:00
 */
public class NettyHttpHandler extends ChannelInboundHandlerAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(NettyHttpHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        if(msg instanceof DefaultHttpRequest){

            DefaultHttpRequest request = (DefaultHttpRequest) msg;

            String uri = request.uri();
            logger.info("uri=[{}]", uri);

           // QueryStringDecoder queryStringDecoder = new QueryStringDecoder(URLDecoder.decode(request.uri(), "utf-8"));


            responseMsg(ctx);

        }
        


    }



    /**
     * Response
     * @param ctx
     */
    private void responseMsg(ChannelHandlerContext ctx) {
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8));
        buildHeader(response);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * build Header
     * @param response
     */
    private void buildHeader(DefaultFullHttpResponse response) {
        HttpHeaders headers = response.headers();
        headers.setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
    }

}
