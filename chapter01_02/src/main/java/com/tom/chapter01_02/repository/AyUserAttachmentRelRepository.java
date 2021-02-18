package com.tom.chapter01_02.repository;

import com.tom.chapter01_02.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * AyUserAttachmentRelRepository
 *
 * @author Tom on 2021/2/18
 */
public interface AyUserAttachmentRelRepository extends MongoRepository<AyUserAttachmentRel,String> {


}
