package com.tom.chapter01_02.repository;

import com.tom.chapter01_02.model.AyUserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AyUserRoleRelRepository
 *
 * @author Tom on 2021/2/18
 */
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel,String> {

    List<AyUserRoleRel> findByUserId(@Param("userId")String userID);
}

