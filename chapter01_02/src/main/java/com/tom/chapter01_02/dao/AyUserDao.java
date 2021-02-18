package com.tom.chapter01_02.dao;

import com.tom.chapter01_02.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AyUserDao
 *
 * @author Tom on 2021/2/17
 */
@Mapper
public interface AyUserDao {

    /**
     *  描述：通过用户名和密码查询用户
     * @param name
     * @param password
     */
    AyUser findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     *  描述：通过用户名查询用户
     * @param name
     */
    AyUser findByUserName(@Param("name") String name);

}