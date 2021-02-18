package com.tom.chapter01_02.service.impl;

import com.tom.chapter01_02.dao.AyUserDao;
import com.tom.chapter01_02.error.BusinessException;
import com.tom.chapter01_02.model.AyUser;
import com.tom.chapter01_02.repository.AyUserRepository;
import com.tom.chapter01_02.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.annotation.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @descriptions: AyUserServiceImpl
 * @author: Tom
 * @date: 2021/2/17 上午 11:49
 * @version: 1.0
 */
//@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {
    Logger logger = LogManager.getLogger(this.getClass());
    @Resource(name = "ayUserRepository")
    private AyUserRepository ayUserRepository;
    @Resource
    private RedisTemplate redisTemplate;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public AyUser findById(String id) {
//        return ayUserRepository.findById(id).orElse(null);
        //step.1  查询Redis缓存中的所有数据
        List<AyUser> ayUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        if(ayUserList != null && ayUserList.size() > 0){
            for(AyUser user : ayUserList){
                if (user.getId().equals(id)){
                    return user;
                }
            }
        }
        //step.2  查询数据库中的数据
        AyUser ayUser = ayUserRepository.findById(id).get();
        if(ayUser != null){
            //step.3 将数据插入到Redis缓存中
            redisTemplate.opsForList().leftPush(ALL_USER, ayUser);
        }
        return ayUser;
    }

    @Override
    public List<AyUser> findAll() {
        try{
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return ayUserList;
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return Collections.EMPTY_LIST;
        }
    }


//    @Transactional
    @Override
    public AyUser save(AyUser ayUser) {
        AyUser ayUser1 = ayUserRepository.save(ayUser);
//        String error = null;
//        error.split("/");
        return ayUser1;
    }

    @Override
    public void delete(String id) {
        logger.info("userId:" + id + "用户被删除");
        ayUserRepository.deleteById(id);
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }
     // Mybatis
     @Resource
     private AyUserDao ayUserDao;
    @Override
    public AyUser findByNameAndPassword(String name, String password) {
         return ayUserDao.findByNameAndPassword(name, password);
    }
    // 异步执行
    @Override
    @Async
    public Future<List<AyUser>> findAsynAll() {
        try{
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return new AsyncResult<List<AyUser>>(ayUserList) ;
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return new AsyncResult<List<AyUser>>(null);
        }
    }
    // 重试
    @Override
    @Retryable(value= {BusinessException.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public AyUser findByNameAndPasswordRetry(String name, String password) {
        System.out.println("[findByNameAndPasswordRetry] 方法失败重试了！");
        throw new BusinessException();
    }

    @Override
    public AyUser findByUserName(String name) {
        return ayUserDao.findByUserName(name);
    }
}
