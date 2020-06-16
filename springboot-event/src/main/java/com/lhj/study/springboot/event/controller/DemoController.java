package com.lhj.study.springboot.event.controller;

import com.lhj.study.springboot.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.hongjian
 * @Date 2020/6/16
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String userName){
        userService.register(userName);
        return "success";
    }

}
