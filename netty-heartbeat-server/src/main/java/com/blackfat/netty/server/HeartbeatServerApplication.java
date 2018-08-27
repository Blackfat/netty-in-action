package com.blackfat.netty.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/27-15:57
 */
@SpringBootApplication
public class HeartbeatServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(HeartbeatServerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(HeartbeatServerApplication.class, args);
        logger.info("启动 Server 成功");
    }
}
