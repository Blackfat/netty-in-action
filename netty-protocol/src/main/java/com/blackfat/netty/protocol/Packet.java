package com.blackfat.netty.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author wangfeiyang
 * @desc   通信协议指令数据包
 * @create 2018/11/1-14:11
 */

@Data
public abstract class Packet {


    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 指令
      * @return
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();


}
