package com.zhang.springboot;

import com.zhang.springboot.listener.MyApplicationEnvironmentPreparedEventListener;
import com.zhang.springboot.listener.MyApplicationFailedEventListener;
import com.zhang.springboot.listener.MyApplicationPreparedEventListener;
import com.zhang.springboot.listener.MyApplicationStartedEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 @SpringBootApplication相当于@EnableAutoConfiguration、@ComponentScan和@Configuration的合集。

1. @EnableAutoConfiguration
Spring Boot自动配置（auto-configuration）：尝试根据你添加的jar依赖自动配置你的Spring应用
2. @ComponentScan
表示将该类自动发现（扫描）并注册为Bean，可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用@ComponentScan注解搜索beans，并结合@Autowired注解导入
3. @Configuration
相当于传统的xml配置文件，如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类——可以使用@ImportResource注解加载xml配置文件
*/
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
}