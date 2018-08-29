package com.blackfat.netty.client.controller;

import com.blackfat.netty.client.HeartbeatClient;
import com.blackfat.netty.client.vo.SendMsgReqVO;
import com.blackfat.netty.client.vo.SendMsgResVO;
import com.blackfat.netty.common.base.BaseResult;
import com.blackfat.netty.common.pojo.CustomProtocol;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/29-10:16
 */
@RestController
@RequestMapping("/")
public class IndexController
{

    @Autowired
    private HeartbeatClient heartbeatClient ;

    /**
     * 向服务端发消息
     * @param sendMsgReqVO
     * @return
     */
    @ApiOperation("客户端发送消息")
    @RequestMapping(value = "sendMsg",method = RequestMethod.POST)
    public BaseResult<SendMsgResVO> sendMsg(@RequestBody SendMsgReqVO sendMsgReqVO){
        heartbeatClient.sendMsg(new CustomProtocol(sendMsgReqVO.getId(),sendMsgReqVO.getMsg())) ;
        SendMsgResVO sendMsgResVO = new SendMsgResVO() ;
        sendMsgResVO.setMsg("OK") ;
        return BaseResult.succeed(sendMsgResVO);
    }
}
