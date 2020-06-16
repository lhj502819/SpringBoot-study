package springcloud.alibaba.bus.rocketmq.demo.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

/**
 * Description：publisher启动类
 *
 * @author li.hongjian
 * @email lhj502819@163.com
 * @Date 2020/6/16
 */
@SpringBootApplication
@RemoteApplicationEventScan //添加Spring Cloud Bus定义的RemoteApplicationEventScan注解，
                            // 声明要从Spring Cloud Bus监听RemoteApplicationEvent事件
public class SpringCloudAlibabaBusListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaBusListenerApplication.class, args);
    }
}
