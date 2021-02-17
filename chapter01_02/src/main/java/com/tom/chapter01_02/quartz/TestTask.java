package com.tom.chapter01_02.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @descriptions: TestTask
 * @author: Tom
 * @date: 2021/2/17 下午 05:27
 * @version: 1.0
 */
@Component
@Configurable
@EnableScheduling
public class TestTask {

    //日志对象
    private static final Logger logger = LogManager.getLogger(TestTask.class);
    @Scheduled(cron = "*/5 * *  * * * ")
    public void run() {
        logger.info("定时器运行了!!!");
    }
}
