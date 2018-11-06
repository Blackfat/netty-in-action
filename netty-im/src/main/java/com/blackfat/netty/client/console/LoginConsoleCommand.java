package com.blackfat.netty.client.console;

import com.blackfat.netty.protocol.LoginRequestPacket;
import com.sun.org.apache.xpath.internal.SourceTree;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:05
 */
public class LoginConsoleCommand implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        System.out.println("请输入用户名：");
        loginRequestPacket.setUserName(scanner.nextLine());
        loginRequestPacket.setPassword("pwd");

        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
