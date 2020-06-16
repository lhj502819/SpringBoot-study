package com.lhj.study.springboot.event.event;

import org.springframework.context.ApplicationEvent;
/**
 * 用户注册事件类
 *
 * @author li.hongjian
 * @Date 2020/6/16
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String userName;

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public String getUserName() {
        return userName;
    }
}
