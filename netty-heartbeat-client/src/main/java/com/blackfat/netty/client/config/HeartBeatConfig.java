package com.blackfat.netty.client.config;

import com.blackfat.netty.common.pojo.CustomProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/28-9:50
 */
@Configuration
/*指定配置文件位置*/
@PropertySource(value = {"classpath:application.properties"},encoding="utf-8")
public class HeartBeatConfig {

    @Value("${channel.id}")
    private long id;


    @Bean(value = "heartBeat")
    public CustomProtocol heartBeat(){
        return new CustomProtocol(id, "ping");
    }






}
