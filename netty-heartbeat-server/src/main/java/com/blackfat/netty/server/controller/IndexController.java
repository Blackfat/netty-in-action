package com.blackfat.netty.server.controller;

import com.blackfat.netty.common.base.BaseResult;
import com.blackfat.netty.common.pojo.CustomProtocol;
import com.blackfat.netty.server.HeartbeatServer;
import com.blackfat.netty.server.vo.SendMsgReqVO;
import com.blackfat.netty.server.vo.SendMsgResVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/29-10:07
 */
@RestController
@RequestMapping("/")
public class IndexController
{
    @Autowired
    private HeartbeatServer heartbeatClient ;


    @ApiOperation("服务端发送消息")
    @RequestMapping(value = "sendMsg",method = RequestMethod.POST)
    public BaseResult<SendMsgResVO> sendMsg(@RequestBody SendMsgReqVO sendMsgReqVO){
        heartbeatClient.sendMsg(new CustomProtocol(sendMsgReqVO.getId(),sendMsgReqVO.getMsg())) ;
        SendMsgResVO sendMsgResVO = new SendMsgResVO() ;
        sendMsgResVO.setMsg("OK") ;
        return BaseResult.succeed(sendMsgResVO);
    }
}
