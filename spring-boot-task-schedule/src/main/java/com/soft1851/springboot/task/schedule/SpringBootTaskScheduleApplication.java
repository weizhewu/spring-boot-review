package com.soft1851.springboot.task.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBootTaskScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskScheduleApplication.class, args);
    }

}
