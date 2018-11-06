package com.blackfat.netty.client.console;

import com.blackfat.netty.protocol.LogoutRequestPacket;
import io.netty.channel.Channel;

import java.util.List;
import java.util.Scanner;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-9:54
 */
public class LogoutConsoleCommand implements ConsoleCommand {



    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
