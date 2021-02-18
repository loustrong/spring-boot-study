package com.tom.chapter01_02.repository;

import com.tom.chapter01_02.model.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AyMoodRepository
 *
 * @author Tom on 2021/2/17
 */
public interface AyMoodRepository extends JpaRepository<AyMood,String> {

}