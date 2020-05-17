package com.soft1851.springboot.task.schedule.repository;

import cn.hutool.log.Log;
import com.soft1851.springboot.task.schedule.model.Coder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 20:17
 * @Description:
 */
@SpringBootTest
class CoderRepositoryTest {
    @Resource
    private CoderRepository coderRepository;
    @Test
    void test(){
        Coder coder = coderRepository.findById(1).get();
        System.out.println(coder);
    }

}