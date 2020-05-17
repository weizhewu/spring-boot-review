package com.soft1851.springboot.task.schedule.controller;

import com.soft1851.springboot.task.schedule.model.User;
import com.soft1851.springboot.task.schedule.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/16 17:21
 * @Description:
 */
@RestController
@Slf4j
public class AsyncTaskController {

    @Resource
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/asyncTask")
    public String asyncTask() {
        asyncTaskService.asyncTask();
        log.info("=======================》》主线程：" + Thread.currentThread().getName());
        return "邮件已发送";
    }
}
