package com.lhj.study.reactor.webflux.controller;

import com.lhj.study.reactor.webflux.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于函数编程的WebFlux
 *
 * @author lihongjian
 * @since 2020/7/22
 */
@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> userListRouterFunction(){
        return RouterFunctions.route(RequestPredicates.GET("/user2/list"),
                new HandlerFunction<ServerResponse>() {
                    @Override
                    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
                        //查询列表
                        List<User> result = new ArrayList<>();
                        result.add(new User().setAge(19).setName("小明").setAddress("北京昌平"));
                        result.add(new User().setAge(19).setName("小红").setAddress("北京大兴"));
                        result.add(new User().setAge(19).setName("小王").setAddress("北京朝阳"));
                        //返回
                        return ServerResponse.ok().bodyValue(result);
                    }
                });
    }
}
