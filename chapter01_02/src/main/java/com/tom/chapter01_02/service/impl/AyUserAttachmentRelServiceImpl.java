package com.tom.chapter01_02.service.impl;

import com.tom.chapter01_02.model.AyUserAttachmentRel;
import com.tom.chapter01_02.repository.AyUserAttachmentRelRepository;
import com.tom.chapter01_02.service.AyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AyUserAttachmentRelServiceImpl
 *
 * @author Tom on 2021/2/18
 */
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {

    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel){
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
