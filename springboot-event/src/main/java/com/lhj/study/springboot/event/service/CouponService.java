package com.lhj.study.springboot.event.service;

import com.lhj.study.springboot.event.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Description：优惠券Service 使用@EventListener注解，并设置监听的事件为UserRegisterEvent，这是另一种使用方式
 *
 * @author li.hongjian
 * @Date 2020/6/16
 */
@Service
public class CouponService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    public void addCoupon(UserRegisterEvent event){
        logger.info("[addCoupon]给用户({})发送优惠券",event.getUserName());
    }

}
