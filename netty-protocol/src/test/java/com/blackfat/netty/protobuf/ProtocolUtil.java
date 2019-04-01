package com.blackfat.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/4/1-16:49
 */
public class ProtocolUtil {

    /**
     * 编码
     * @param protocol
     * @return
     */
    public static byte[] encode(BaseRequestProto.RequestProtocol protocol){
        return protocol.toByteArray() ;
    }
    /**
     * 解码
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public static BaseRequestProto.RequestProtocol decode(byte[] bytes) throws InvalidProtocolBufferException {
        return BaseRequestProto.RequestProtocol.parseFrom(bytes);
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        BaseRequestProto.RequestProtocol protocol = BaseRequestProto.RequestProtocol.newBuilder()
                .setRequestId(123)
                .setReqMsg("hello world")
                .build();
        byte[] encode = encode(protocol);
        BaseRequestProto.RequestProtocol parseFrom = decode(encode);
        System.out.println(protocol.toString());
        System.out.println(protocol.toString().equals(parseFrom.toString()));
    }
}
