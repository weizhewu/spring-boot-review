package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 20:39
 * @Description:
 */
//@Slf4j
//@Component
//@Configuration
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected CronRepository cronRepository;

    @Bean
    public Executor setTaskExecutors(){
        //创建一个基本大小为3的线程池
        return Executors.newScheduledThreadPool(3);
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() ->{

        },
                triggerContext -> {
                    return new CronTrigger("newCorn").nextExecutionTime(triggerContext);
                }
        );

    }

}
