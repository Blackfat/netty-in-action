package com.blackfat.netty.util;

import com.blackfat.netty.attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;


/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-16:02
 */
public class LoginUtil {

    /**
     * 标识客户端已经登陆
     * @param channel
     */
    public static void  markAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 判断客户端是否登陆
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
