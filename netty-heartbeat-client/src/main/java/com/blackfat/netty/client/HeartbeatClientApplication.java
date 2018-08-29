package com.blackfat.netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/29-13:37
 */
@SpringBootApplication
public class HeartbeatClientApplication {

    private static final Logger logger = LoggerFactory.getLogger(HeartbeatClientApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(HeartbeatClientApplication.class, args);
        logger.info("启动 Server 成功");
    }
}
