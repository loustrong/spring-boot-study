package com.tom.chapter01_02.repository;

import com.tom.chapter01_02.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @descriptions: AyUserRepository
 * @author: Tom
 * @date: 2021/2/17 上午 11:42
 * @version: 1.0
 */
@Repository
public interface AyUserRepository extends JpaRepository<AyUser,String> {
        /**
         * 通過名字相等查詢,參數為name
         * 相當於: select u.* from ay_user u where u.name =?1
         * @param name
         * @return
         */
        List<AyUser> findByName(String name);

        /**
         * 通過like語句查詢
         * @param name
         * @return
         */
        List<AyUser> findByNameLike(String name);

        /**
         * 通過主鍵id集合查詢,參數為id集合
         * @param ids
         * @return
         */
        List<AyUser> findByIdIn(Collection<String> ids);
}
