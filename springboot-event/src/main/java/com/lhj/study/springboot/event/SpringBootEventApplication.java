package com.lhj.study.springboot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync//开启Spring异步功能
public class SpringBootEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEventApplication.class, args);
	}

}
