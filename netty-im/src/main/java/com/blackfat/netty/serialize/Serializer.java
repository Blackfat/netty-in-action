package com.blackfat.netty.serialize;

import com.blackfat.netty.serialize.impl.JSONSerializer;

/**
 * @author wangfeiyang
 * @desc    序列化接口
 * @create 2018/11/1-14:25
 */
public interface Serializer {

    /**
     * 默认序列化算法
     */
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);


    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);



}
