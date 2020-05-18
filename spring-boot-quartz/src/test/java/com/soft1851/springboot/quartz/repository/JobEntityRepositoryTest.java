package com.soft1851.springboot.quartz.repository;

import cn.hutool.core.lang.Console;
import com.soft1851.springboot.quartz.entity.JobEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/18 22:10
 * @Description:
 */
@SpringBootTest
class JobEntityRepositoryTest {
    @Resource
    private JobEntityRepository jobEntityRepository;

    @Test
    void getById() {
        JobEntity jobEntity = jobEntityRepository.getById(1);
        Console.log(jobEntity.getDescription());
    }
}