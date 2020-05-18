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

    @Test
    void updateAvatar() {
    }

    @Test
    void testSave() {
        Coder coder1 = Coder.builder()
                .name("mqxu")
                .url("https://github.com/mqxu")
                .avatar("https://avatars1.githubusercontent.com/u/42235689?s=100&v=4")
                .build();
        Coder coder2 = Coder.builder()
                .name("taoyongxin")
                .url("https://github.com/taoyongxin")
                .avatar("https://avatars2.githubusercontent.com/u/55398415?s=100&v=4")
                .build();
        Coder coder3 = Coder.builder()
                .name("LibraZYJ")
                .url("https://github.com/LibraZYJ")
                .avatar("https://avatars2.githubusercontent.com/u/55378225?s=100&v=4")
                .build();
        Coder coder4 = Coder.builder()
                .name("wangfeng351")
                .url("https://github.com/wangfeng351")
                .avatar("https://avatars1.githubusercontent.com/u/55400115?s=100&v=4")
                .build();
        coderRepository.save(coder1);
        coderRepository.save(coder2);
        coderRepository.save(coder3);
        coderRepository.save(coder4);
    }
}