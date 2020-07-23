package com.lhj.study.reactor.mono;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Ractor Mono
 *
 * @author lihongjian
 * @since 2020/7/22
 */
public class MonoDemo {
    public static void main(String[] args) {
        //创建Mono序列
        Mono.fromSupplier(()->"Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("World")).subscribe(System.out::println);
        Mono.create(monoSink -> monoSink.success("Java")).subscribe(System.out::println);

    }
}
