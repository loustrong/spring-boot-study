package com.tom.chapter01_02;

import com.tom.chapter01_02.service.AyUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

//@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableAsync
//@ImportResource(locations={"classpath*:spring-mvc.xml"})
//@EnableRetry
public class Chapter01Application {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private AyUserService ayUserService;

    public static void main(String[] args) {
        SpringApplication.run(Chapter01Application.class, args);
    }

}
