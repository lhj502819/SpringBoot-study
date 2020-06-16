package springcloud.alibaba.bus.rocketmq.demo.publisher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.alibaba.bus.rocketmq.demo.publisher.event.UserRegisterEvent;

/**
 * Description：
 *
 * @author li.hongjian
 * @email lhj502819@163.com
 * @Date 2020/6/16
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ServiceMatcher serviceMatcher;

    @GetMapping("/register")
    public String register(String userName){
        // 执行用户注册逻辑
        logger.info("[register][执行用户{}的注册逻辑]",userName);
        // 发布事件
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this,serviceMatcher.getServiceId(),null,userName));
        return "success";

    }

}
