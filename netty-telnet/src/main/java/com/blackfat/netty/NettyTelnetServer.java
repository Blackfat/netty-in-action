package com.blackfat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/17-13:53
 */
public class NettyTelnetServer {

    private static final int port = 8888;

    private ServerBootstrap serverBootstrap;

    private EventLoopGroup bossGroup = new NioEventLoopGroup();  // 接受客户端请求

    private EventLoopGroup workerGroup = new NioEventLoopGroup(); // 处理客户端读写操作


    public void open() throws InterruptedException {
        serverBootstrap = new ServerBootstrap();     // 应用程序网络层配置的容器
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);// tcp socket的backlog参数

        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)   // 底层网络传输 API必须提供给应用 I/O操作的接口
                .handler(new LoggingHandler(LogLevel.INFO)) // 监听初始化channel的各种动作
                /*
                * 这里的handle分为两种类型：
                *    1：ChannelInboundHandler：用来处理客户端的消息，比如对客户端的消息进行解码，读取，该类型在pipeline中的执行顺序与添加顺序一致
                *    2：ChannelOutboundHandler：用来处理发往客户端的消息，比如对消息进行编码和编辑，该类型在pipeline中的执行顺序与添加顺序相反
                * */
                .childHandler(new NettyTelnetInitializer());// 监听已经连接到客户端的channel的状态


        ChannelFuture future =serverBootstrap.bind(port).sync();//配置完成，绑定server，并通过sync同步方法阻塞直到绑定成功
        future.channel().closeFuture().sync();//应用程序会一直等待，直到channel关闭

    }

    public void close(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        NettyTelnetServer nettyTelnetServer = new NettyTelnetServer();
        try {
            nettyTelnetServer.open();
        } catch (InterruptedException e) {
            nettyTelnetServer.close();
        }
    }

}
