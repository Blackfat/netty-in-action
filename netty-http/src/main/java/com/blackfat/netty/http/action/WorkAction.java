package com.blackfat.netty.http.action;

import com.blackfat.netty.http.action.param.Param;
import com.blackfat.netty.http.action.res.WorkRes;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-17:28
 */
public interface WorkAction {

    /**
     * abstract execute method
     * @param param
     * @return
     * @throws Exception
     */
    WorkRes execute(Param param) throws Exception;
}
