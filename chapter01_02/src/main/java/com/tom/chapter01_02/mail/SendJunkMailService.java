package com.tom.chapter01_02.mail;

import com.tom.chapter01_02.model.AyUser;

import java.util.List;

/**
 * SendJunkMailService
 *
 * @author Tom on 2021/2/17
 */
public interface SendJunkMailService {

    boolean sendJunkMail(List<AyUser> ayUser);
}
