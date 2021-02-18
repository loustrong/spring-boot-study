package com.tom.chapter01_02.service.impl;

import com.tom.chapter01_02.model.AyUserRoleRel;
import com.tom.chapter01_02.repository.AyUserRoleRelRepository;
import com.tom.chapter01_02.service.AyUserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * AyUserRoleServiceImpl
 *
 * @author Tom on 2021/2/18
 */
@Service
public class AyUserRoleServiceImpl implements AyUserRoleRelService {

    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;

    @Override
    public List<AyUserRoleRel> findByUserId(String userId) {
        return ayUserRoleRelRepository.findByUserId(userId);
    }
}
