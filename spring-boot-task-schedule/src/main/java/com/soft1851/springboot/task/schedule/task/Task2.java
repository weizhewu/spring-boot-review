package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.model.User;
import com.soft1851.springboot.task.schedule.repository.UserRepository;
import com.soft1851.springboot.task.schedule.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/14 21:20
 * @Description:
 */
//@Component
public class Task2 {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;

    @Scheduled(cron = "0 57 18 * * ?")
    public void reportCurrentTime() throws MessagingException {
        List<User> users = userRepository.findUsersByBirthday();
        String to = "weizhewu232623@gmail.com";
        String subject = "生日快乐";

//        String content = "<div id=\"app\"><div style=\"width: 400px;height: 450px;padding: 10px 10px;border: 1px solid #eee;box-shadow: -2px -2px 10px rgba(0, 0, 0, 0.5);margin: auto;\"><div style=\"width: 100%;height: 200px;\"><img src=\"https://i.loli.net/2020/05/12/dVMKqUEn5wfusX4.jpg\" alt=\"\" style=\"width: 100%;height: 100%;\" /></div><div style=\"width: 100%;height: 200px;margin-top: 30px;\"><span>Hi</span><p class=\"con-body\" style=\"text-indent: 2em;\">有些事情可能你已经忘记，但我们依然记得。</br>今天是你的生日，我们唱了一首歌送给你，希望它能给你带来一些惊喜和欢乐。Happy Birthday。</p><div style=\"text-align: center;margin-top: 30px;\"><button style=\"width: 160px;height: 45px;background: rgb(80, 151, 239); border-radius: 4px;color: white;border: none;\">开始</button></div></div> </div></div>";
        for (User user : users){
            //创建邮件
            Context context = new Context();
            context.setVariable("userName",user.getNickName());
            //将字段加载到页面模板中
            String emailContent = templateEngine.process("Card",context);
            mailService.sendHtmlMail(to,user.getNickName()+subject,emailContent);
            System.out.println("邮件已发送");
        }
//        System.out.println("现在时间：" + dtf.format( LocalDateTime.now()));
    }
}
