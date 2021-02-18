package com.tom.chapter01_02.service.impl;

import com.tom.chapter01_02.model.AyRole;
import com.tom.chapter01_02.repository.AyRoleRepository;
import com.tom.chapter01_02.service.AyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AyRoleServiceImpl
 *
 * @author Tom on 2021/2/18
 */
@Service
public class AyRoleServiceImpl implements AyRoleService {

    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id){
        return ayRoleRepository.findById(id).get();
    }
}

