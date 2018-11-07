package com.blackfat.netty.http.controller;

import com.blackfat.netty.http.action.WorkAction;
import com.blackfat.netty.http.action.param.Param;
import com.blackfat.netty.http.action.res.WorkRes;
import com.blackfat.netty.http.annotation.CicadaAction;
import com.blackfat.netty.http.enums.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/7-9:31
 */
@CicadaAction(value = "/demoAction")
public class DemoAction implements WorkAction {


    private static final Logger logger = LoggerFactory.getLogger(DemoAction.class);

    private static AtomicLong index = new AtomicLong() ;

    @Override
    public WorkRes execute(Param paramMap) throws Exception {
        String name = paramMap.getString("name");
        Integer id = paramMap.getInteger("id");
        logger.info("name=[{}],id=[{}]" , name,id);
        WorkRes res = new WorkRes();
        res.setCode(StatusEnum.SUCCESS.getCode());
        res.setMessage(StatusEnum.SUCCESS.getMessage());
        return res;
    }

}
