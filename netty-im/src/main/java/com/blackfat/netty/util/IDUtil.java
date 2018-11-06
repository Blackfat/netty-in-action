package com.blackfat.netty.util;

import java.util.UUID;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-10:32
 */
public class IDUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
