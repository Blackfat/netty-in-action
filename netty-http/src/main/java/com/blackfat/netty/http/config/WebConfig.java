package com.blackfat.netty.http.config;

import lombok.Data;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-15:39
 */
@Data
public class WebConfig {

    public static final WebConfig INSTANCE = new WebConfig();

    private WebConfig(){

    }

    private String rootPackageName ;

    private String rootPath ;

    private Integer port = 7317 ;

}
