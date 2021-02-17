package com.tom.chapter01_02.controller;

import com.tom.chapter01_02.model.AyUser;
import com.tom.chapter01_02.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @descriptions: AyUserController
 * @author: Tom
 * @date: 2021/2/17 下午 01:58
 * @version: 1.0
 */
@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;
    @RequestMapping("/test")
    public String test(Model model) {
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users",ayUser);
        return "ayUser";
    }
}
