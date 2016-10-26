package com.zhang.springboot.config;

/**
 * Description: [ma文件引用]
 * Created on 2016/10/12
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:activemq/spring-activemq.xml"})
public class ConfigClass {

}
