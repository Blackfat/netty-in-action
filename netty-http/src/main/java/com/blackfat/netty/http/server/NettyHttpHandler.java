package com.blackfat.netty.http.server;

import com.alibaba.fastjson.JSON;
import com.blackfat.netty.http.action.WorkAction;
import com.blackfat.netty.http.action.param.Param;
import com.blackfat.netty.http.action.param.ParamMap;
import com.blackfat.netty.http.action.res.WorkRes;
import com.blackfat.netty.http.config.WebConfig;
import com.blackfat.netty.http.enums.StatusEnum;
import com.blackfat.netty.http.exception.CicadaException;
import com.blackfat.netty.http.util.ClassScanner;
import com.blackfat.netty.http.util.PathUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

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

            QueryStringDecoder queryStringDecoder = new QueryStringDecoder(URLDecoder.decode(request.uri(), "utf-8"));

            // check Root Path
            WebConfig webConfig = checkRootPath(uri, queryStringDecoder);

            // route Action
            Class<?> actionClazz = routeAction(queryStringDecoder, webConfig);

            //build paramMap
            Param paramMap = buildParamMap(queryStringDecoder);

            // execute Method
            WorkAction action = (WorkAction) actionClazz.newInstance();
            WorkRes execute = action.execute(paramMap);


            responseMsg(ctx, execute);

        }
        


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        WorkRes workRes = new WorkRes() ;
        workRes.setCode(String.valueOf(HttpResponseStatus.NOT_FOUND.code()));
        workRes.setMessage(cause.getMessage());

        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND, Unpooled.copiedBuffer(JSON.toJSONString(workRes), CharsetUtil.UTF_8)) ;
        buildHeader(response);
        ctx.writeAndFlush(response);
    }

    /**
     * route Action
     * @param queryStringDecoder
     * @param webConfig
     * @return
     * @throws Exception
     */
    private Class<?> routeAction(QueryStringDecoder queryStringDecoder, WebConfig webConfig) throws Exception {
        String actionPath = PathUtil.getActionPath(queryStringDecoder.path());
        Map<String, Class<?>> cicadaAction = ClassScanner.getCicadaAction(webConfig.getRootPackageName());

        if (cicadaAction == null){
            throw new CicadaException("Must be configured WorkAction Object") ;
        }

        Class<?> actionClazz = cicadaAction.get(actionPath);
        if (actionClazz == null){
            throw new CicadaException(StatusEnum.REQUEST_ERROR,actionPath + " Not Fount") ;
        }
        return actionClazz;
    }


    /**
     * build paramMap
     * @param queryStringDecoder
     * @return
     */
    private Param buildParamMap(QueryStringDecoder queryStringDecoder) {
        Map<String, List<String>> parameters = queryStringDecoder.parameters();
        Param paramMap = new ParamMap() ;
        for (Map.Entry<String, List<String>> stringListEntry : parameters.entrySet()) {
            String key = stringListEntry.getKey();
            List<String> value = stringListEntry.getValue();
            paramMap.put(key,value.get(0)) ;
        }
        return paramMap;
    }

    /**
     * check Root Path
     * @param uri
     * @param queryStringDecoder
     * @return
     */
    private WebConfig checkRootPath(String uri, QueryStringDecoder queryStringDecoder) {
        WebConfig webConfig = WebConfig.INSTANCE;
        if (!PathUtil.getRootPath(queryStringDecoder.path()).equals(webConfig.getRootPath())){
            throw new CicadaException(StatusEnum.REQUEST_ERROR,uri) ;
        }
        return webConfig;
    }








    /**
     * Response
     * @param ctx
     */
    private void responseMsg(ChannelHandlerContext ctx, WorkRes execute) {
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(JSON.toJSONString(execute), CharsetUtil.UTF_8));
        buildHeader(response);
        // 操作完成关闭连接
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * build Header
     * @param response
     */
    private void buildHeader(DefaultFullHttpResponse response) {
        HttpHeaders headers = response.headers();
        headers.setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        headers.set(HttpHeaderNames.CONTENT_TYPE, "application/json");
    }

}
