package com.soft1851.springboot.task.schedule.service;

import com.soft1851.springboot.task.schedule.model.JobEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/18 21:25
 * @Description:
 */
@SpringBootTest
class DynamicJobServiceTest {
    @Resource
    private DynamicJobService dynamicJobService;

    @Test
    void getJobEntityById() {
        JobEntity jobEntity = dynamicJobService.getJobEntityById(1);
        System.out.println(jobEntity.getCron());
    }

    @Test
    void loadJobs() {
    }

    @Test
    void getJobDataMap() {
    }

    @Test
    void getJobDetail() {
    }

    @Test
    void getTrigger() {
    }

    @Test
    void getJobKey() {
    }
}