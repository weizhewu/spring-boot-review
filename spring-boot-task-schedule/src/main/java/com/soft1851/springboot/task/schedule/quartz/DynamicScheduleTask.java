package com.soft1851.springboot.task.schedule.quartz;

import com.soft1851.springboot.task.schedule.jobs.TestJob;
import org.quartz.SchedulerException;

/**
 * @Author: zw_w
 * @Date: 2020/5/18 18:58
 * @Description:
 */
public class DynamicScheduleTask {
    public static void main(String[] args) throws SchedulerException {
        //添加任务，注意各个参数的作用
//        QuartzManager.addJob("testJog","jobGroup1","testTrigger","triggerGroup1", TestJob.class,2);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        QuartzManager.addJog("testJob","jobGroup1","testTrigger","triggerGroup1",TestJob.class,"0/5 * * * * ?");

        //修改任务
        QuartzManager.modifyJobTime("testTrigger","triggerGroup1",5);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //删除任务
        QuartzManager.removeJob("testJob","jobGroup1","testTrigger","triggerGroup1");
        QuartzManager.shutdownJobs();
    }
}
