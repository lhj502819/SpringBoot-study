package springcloud.alibaba.bus.rocketmq.demo.listener.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import springcloud.alibaba.bus.rocketmq.demo.listener.event.UserRegisterEvent;

/**
 * Description：用户注册事件监听器
 *
 * @author li.hongjian
 * @email lhj502819@163.com
 * @Date 2020/6/16
 */
@Component
public class UserRegisterListener implements ApplicationListener<UserRegisterEvent>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        logger.info("[onApplicationEvent][监听到用户({})]",userRegisterEvent.getUserName());
    }
}
