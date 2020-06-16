package springcloud.alibaba.bus.rocketmq.demo.listener.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * Description：用户注册事件
 *
 * @author li.hongjian
 * @email lhj502819@163.com
 * @Date 2020/6/16
 */
public class UserRegisterEvent extends RemoteApplicationEvent {
    /**
     * 用户名
     */
    private String userName;

    public UserRegisterEvent() {
    }

    public UserRegisterEvent(Object source, String originService, String destinationService, String userName) {
        super(source, originService, destinationService);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
