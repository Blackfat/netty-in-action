package com.blackfat.netty.http.server;

import com.blackfat.netty.http.config.WebConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/3-13:58
 */
public class NettyHttpServer {

    private static final Logger logger = LoggerFactory.getLogger(NettyHttpServer.class);

    private static final int port = 8080;

    private static final int BOSS_SIZE = Runtime.getRuntime().availableProcessors() * 2;

    private ServerBootstrap serverBootstrap;

    private EventLoopGroup bossGroup = new NioEventLoopGroup(BOSS_SIZE);  // 接受客户端请求

    private EventLoopGroup workerGroup = new NioEventLoopGroup(); // 处理客户端读写操作

    public void open(Class<?> clazz,String path) throws InterruptedException {
        try{
            long start = System.currentTimeMillis();


            //init application
            WebConfig.INSTANCE.setRootPackageName(clazz.getPackage().getName());
            WebConfig.INSTANCE.setRootPath(path);

            serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NettyHttpInitializer());


            ChannelFuture future =serverBootstrap.bind(port).sync();//配置完成，绑定server，并通过sync同步方法阻塞直到绑定成功
            if (future.isSuccess()) {
                long end = System.currentTimeMillis();
                logger.info("server started on port: {}.cost {}ms", port ,end-start);
            }

            future.channel().closeFuture().sync();//应用程序会一直等待，直到channel关闭

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
