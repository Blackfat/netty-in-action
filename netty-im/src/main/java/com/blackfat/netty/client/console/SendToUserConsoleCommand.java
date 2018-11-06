package com.blackfat.netty.client.console;

import com.blackfat.netty.protocol.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-9:54
 */
public class SendToUserConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
