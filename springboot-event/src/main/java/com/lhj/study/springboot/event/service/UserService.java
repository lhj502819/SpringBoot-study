package com.lhj.study.springboot.event.service;

import com.lhj.study.springboot.event.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Description：用户Service类 实现{@link ApplicationEventPublisherAware}，从而将ApplicationEventPublisher注入到其中。
 *
 * @author li.hongjian
 * @Date 2020/6/16
 */
@Service
public class UserService implements ApplicationEventPublisherAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String userName){
        //执行注册逻辑
        logger.info("[register][执行用户{}的注册逻辑]",userName);

        //...发布
        //在执行完注册逻辑之后，调用ApplicationEventPublisher#publishEvent，发布UserRegisterEvent
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this,userName));
    }
}
