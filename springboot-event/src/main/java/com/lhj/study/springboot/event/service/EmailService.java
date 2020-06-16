package com.lhj.study.springboot.event.service;

import com.lhj.study.springboot.event.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Description：邮箱Service 实现{@link ApplicationListener}，通告设置泛型设置感兴趣的类型，此处对UserRegisterEvent感兴趣
 *
 * @author li.hongjian
 * @Date 2020/6/16
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Async//声明异步执行。实际场景下发送邮件可能比较慢，又是非关键逻辑
    public void onApplicationEvent(UserRegisterEvent event) {
        logger.info("[onApplicationEvent]给用户({}) 发送注册邮件",event.getUserName());
    }
}
