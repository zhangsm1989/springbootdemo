package com.zhang.springboot.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Description: [定时任务]
 * Created on 2016/11/3
 *
 * @author <a href="mailto: zhangshanming@camelotchina.com">张山明</a>
 * @version 1.0
 *          Copyright (c) 2016年 北京柯莱特科技有限公司 交付部
 */
//@Configuration  //TODO 定时任务注销
//@EnableScheduling
public class SchedulingConfig {

    @Scheduled(cron = "0/20 * * * * ?")// 每20秒执行一次
    public void scheduler() {
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }
}
