package com.blackfat.netty.http;

import com.blackfat.netty.http.server.NettyHttpServer;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/7-9:33
 */
public class MainStart {

    public static void main(String[] args) throws Exception {
        NettyHttpServer.start(MainStart.class,"/cicada-example") ;
    }
}
