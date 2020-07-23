package com.lhj.study.reactor.webflux.controller;

import com.lhj.study.reactor.webflux.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于Annotated  Controller方式实现
 *
 * @author lihongjian
 * @since 2020/7/22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/getUser")
    public Flux<User> getUserList(){
        List<User> result = new ArrayList<>();
        result.add(new User().setAge(19).setName("小明").setAddress("北京昌平"));
        result.add(new User().setAge(19).setName("小红").setAddress("北京大兴"));
        result.add(new User().setAge(19).setName("小王").setAddress("北京朝阳"));
        return Flux.fromIterable(result);
    }

    @GetMapping("getUserInfo")
    public Mono<User> getUserInfo(){
        return Mono.just(new User().setAge(10).setName("王无").setAddress("天津"));
    }

}
