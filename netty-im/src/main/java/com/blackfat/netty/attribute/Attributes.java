package com.blackfat.netty.attribute;

import com.blackfat.netty.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-16:00
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
