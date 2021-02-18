package com.tom.chapter01_02.quartz;

import com.tom.chapter01_02.mail.SendJunkMailService;
import com.tom.chapter01_02.model.AyUser;
import com.tom.chapter01_02.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * SendMailQuartz
 *
 * @author Tom on 2021/2/17
 */
@Component
@Configurable
//@EnableScheduling
public class SendMailQuartz {

    //日志对象
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

    @Resource
    private SendJunkMailService sendJunkMailService;
    @Resource
    private AyUserService ayUserService;

    //每5秒执行一次
    @Scheduled(cron = "*/10 * *  * * * ")
    public void reportCurrentByCron(){
        List<AyUser> userList = ayUserService.findAll();
        if (userList == null || userList.size() <= 0) return;
        //发送邮件
        sendJunkMailService.sendJunkMail(userList);
        logger.info("发送邮件的定时器运行了!!!");
    }

}