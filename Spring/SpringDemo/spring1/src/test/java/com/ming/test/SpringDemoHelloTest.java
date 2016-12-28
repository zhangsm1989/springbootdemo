package com.ming.test;

import com.ming.spring1.HelloApi;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: [单元测试]
 * Created on 2016-12-28
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */

public class SpringDemoHelloTest {

    @Test
    public void testBean1(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
//         一、  不指定id，只配置必须的全限定类名
        HelloApi helloApi = beanFactory.getBean(HelloApi.class);
        helloApi.sayHello("no id");
    }
    @Test
    public void testBean2(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
//        二、指定id，必须在Ioc容器中唯一；
        HelloApi helloApi = beanFactory.getBean("helloBean1",HelloApi.class);
        helloApi.sayHello("id");
    }
    @Test
    public void testBean3(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
//        三、指定name，这样name就是“标识符”，必须在Ioc容器中唯一；
        HelloApi helloApi = beanFactory.getBean("helloBean3",HelloApi.class);
        helloApi.sayHello("id");
    }
    @Test
    public void testBean4(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
//    四、指定id和name，id就是标识符，而name就是别名，必须在Ioc容器中唯一；
//        根据id获得
        HelloApi helloApi_id = beanFactory.getBean("helloId4",HelloApi.class);
        helloApi_id.sayHello("id");
//        根据别名获得
        HelloApi helloApiAliasBean = beanFactory.getBean("aliasBean",HelloApi.class);
        helloApiAliasBean.sayHello("aliasBean");
//        如果id和name一致,Ioc容器能检测到,并消除
        HelloApi helloApi1 = beanFactory.getBean("helloBean4_1",HelloApi.class);
        helloApi1.sayHello("id+name");
    }

}
