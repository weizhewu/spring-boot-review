package com.soft1851.springboot.task.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.annotation.Resource;
import org.thymeleaf.context.Context;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/16 17:20
 * @Description:
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;

    @Async
    public void asyncTask() {
//        try {
//            Thread.sleep(5000);
//            //创建邮件字段
//            Context context = new Context();
//            context.setVariable("siteTitle", "【阅片无数46】");
//            context.setVariable("title", "你管这叫抢银行？");
//            context.setVariable("author", "测试");
//            context.setVariable("time", "2019-07-16 08:52:46");
//            context.setVariable("text", "测试");
//            context.setVariable("ip", "127.0.0.1");
//            context.setVariable("mail", "1797262364@qq.com");
//            context.setVariable("status", "1");
//            // 将字段加载到页面模板中
//            String emailContent = templateEngine.process("Card", context);
//            mailService.sendHtmlMail("2316860587@qq.com", "主题", emailContent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("邮件发送成功");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
    }
}