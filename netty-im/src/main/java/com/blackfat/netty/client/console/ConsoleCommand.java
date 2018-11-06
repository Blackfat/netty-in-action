package com.blackfat.netty.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author wangfeiyang
 * @desc   控制台操作抽象类
 * @create 2018/11/6-9:48
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);

}
