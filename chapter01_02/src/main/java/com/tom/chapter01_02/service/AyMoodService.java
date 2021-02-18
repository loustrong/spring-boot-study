package com.tom.chapter01_02.service;

import com.tom.chapter01_02.model.AyMood;

/**
 * AyMoodService
 *
 * @author Tom on 2021/2/17
 */
public interface AyMoodService {

    AyMood save(AyMood ayMood);

    String asynSave(AyMood ayMood);

}
