package com.lhj.study.reactor.flux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author lihongjian
 * @since 2020/7/21
 */
public class FluxDemo1 {

    public static final Logger logger = LoggerFactory.getLogger(FluxDemo1.class);

    public static void main(String[] args) {
        /**
         * just()：可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束。
         * fromArray()，fromIterable()和 fromStream()：可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
         * empty()：创建一个不包含任何元素，只发布结束消息的序列。
         * error(Throwable error)：创建一个只包含错误消息的序列。
         * never()：创建一个不包含任何消息通知的序列。
         * range(int start, int count)：创建包含从 start 起始的 count 个数量的 Integer 对象的序列。
         * interval(Duration period)和 interval(Duration delay, Duration period)：创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。除了间隔时间之外，还可以指定起始元素发布之前的延迟时间。
         * intervalMillis(long period)和 intervalMillis(long delay, long period)：与 interval()方法的作用相同，只不过该方法通过毫秒数来指定时间间隔和延迟时间。
         */
        Flux<String> just = Flux.just("hello Word", "Spring Boot");
        just.subscribe(System.out::println).dispose();
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println).dispose();
        /**
         * generate()方法生成Flux
         * generate()方法通过同步和逐一的方式来产生Flux序列。序列产生是通过调用SynchronousSink对象的next()、Complete()和error方法完成的
         * 逐一生成的含义是在具体的生成逻辑中，next()方法最多只能被调用一次。
         *
         * 在下边的代码中，通过next()方法产生一个简单的值，然后通过complete()方法来结束该序列。如果不调用complete()方法，所产生的是一个无限序列。
         *
         * 第二个序列的生成逻辑中的状态对象是一个ArrayList对象，实际产生的值是一个随机数，产生的随机数被放入ArrayList中。当产生了10个值的时候就调用complete()方法停止。
         */
        Flux.generate(sink -> {
            sink.next("字符串");
            sink.complete();
        }).subscribe().dispose();


        final Random random = new Random();
        Flux.generate(ArrayList::new,
                (list, sink) -> {
                    int value = random.nextInt(100);
                    list.add(value);
                    sink.next(value);
                    if (list.size() == 10) {
                        sink.complete();
                    }
                    return list;
                }).subscribe(System.out::println);

        /**
         * create()方法生成Flux
         * create()方法与generate()方法的不同之处在于所使用的是FluxSink对象，
         * FluxSink支持同步和异步的消息产生，并且可以在一次调用中产生多个元素。
         * 在下边的代码中，在一次调用中就产生了全部的十个元素
         */
        logger.info("**********create()方法************");
        Flux.create(fluxSink -> {
            for (int i = 0 ; i < 10 ; i++){
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).subscribe(System.out::println);
        logger.info("********************buffer相关操作符***********************");
        /**
         * buffer相关操作符使用示例
         */
        ArrayList<Integer> list = null;

        logger.info("==========================buffer===============================");

        Flux.range(0,100).buffer(20).subscribe(System.out::println);

        logger.info("==========================bufferUntil===============================");

        Flux.range(0,100).bufferUntil(i -> i%4==0).take(3).toStream().forEach(System.out::println);

        /**
         * filter 对流中包含的元素进行过滤，只留下满足Predicate的元素。以下示例中的语句输出的1到10中的偶数
         */
        logger.info("==========================filter===============================");
        Flux.range(1,10).filter(i -> i%2==0).subscribe(System.out::println);

        logger.info("==========================windows操作符===============================");
        /**
         * windows操作符
         * windows操作符类似于buffer，所不同的是windows操作符是把当前流中的元素收集到另外的Flux序列中，因此返回值类型是Flux<Flux>
         */
        Flux.range(1,100).window(20).subscribe(System.out::println);
        logger.info("==========================zipWith===============================");
        /**
         * zipWith
         */
        Flux.just(1,2).zipWith(Flux.just(3,4)).subscribe(System.out::println);
        Flux.just(1,2).zipWith(Flux.just(3,4),(s1,s2)->String.format("%s-%s",s1,s2)).subscribe(System.out::println);

        List<String> list1 = new ArrayList<>();
        logger.info("==========================reduce 和 reduceWith===============================");

        /**
         * reduce 和 reduceWith ：可以指定初始值
         */
        Flux.range(1,100).reduce((i1,i2)->i1+i2).subscribe(System.out::println);
        //通过Supplier
        Flux.range(1,100).reduceWith(()->100,(i1,i2)->i1+i2).subscribe(System.out::println);

        logger.info("==========================concatMap===============================");
        /**
         * concatMap
         */
    }

}
