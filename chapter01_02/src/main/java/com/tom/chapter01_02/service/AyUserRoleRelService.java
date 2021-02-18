package com.tom.chapter01_02.service;

import com.tom.chapter01_02.model.AyUserRoleRel;

import java.util.List;

/**
 * AyUserRoleRelService
 *
 * @author Tom on 2021/2/18
 */
public interface AyUserRoleRelService {

    List<AyUserRoleRel> findByUserId(String userId);
}

