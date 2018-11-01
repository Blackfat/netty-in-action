package com.blackfat.netty.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.blackfat.netty.serialize.Serializer;
import com.blackfat.netty.serialize.SerializerAlogrithm;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/1-14:29
 */
public class JSONSerializer implements Serializer {


    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
