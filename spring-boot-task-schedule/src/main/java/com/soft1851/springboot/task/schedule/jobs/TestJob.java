package com.soft1851.springboot.task.schedule.jobs;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: zw_w
 * @Date: 2020/5/18 17:45
 * @Description: 执行的任务
 */
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Console.log("当前时间：{}", DateUtil.now());
    }
}
