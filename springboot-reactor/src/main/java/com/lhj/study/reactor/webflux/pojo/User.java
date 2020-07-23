package com.lhj.study.reactor.webflux.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author lihongjian
 * @since 2020/7/22
 */
@Accessors(chain = true)
@Data()
public class User {
    private String name;
    private Integer age;
    private String address;
}
