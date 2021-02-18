package com.tom.chapter01_02.repository;

import com.tom.chapter01_02.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AyRoleRepository
 *
 * @author Tom on 2021/2/18
 */
public interface AyRoleRepository extends JpaRepository<AyRole,String> {

}