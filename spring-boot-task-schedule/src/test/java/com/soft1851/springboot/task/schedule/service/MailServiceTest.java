package com.soft1851.springboot.task.schedule.service;

import com.soft1851.springboot.task.schedule.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 15:23
 * @Description:
 */
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "";
        String subject ="小傻子专属";
        String content = "<h3>大大的小傻子</h3>";
        mailService.sendSimpleTextMail(to,subject,content);
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        String to = "";
        String subject ="小傻子专属";
        String content = "<h3>大大的小傻子</h3>";
        mailService.sendHtmlMail(to,subject,content);

    }

    @Test
    void sendAttachmentMail() throws Exception {
        String to = "weizhewu232623@gmail.com";
        String subject ="小傻子千万别打开";
        String content = "<h3>大大的小傻子</h3>";
        String imgPath = "D:\\还是小傻子.png";
        mailService.sendAttachmentMail(to,subject,content,imgPath);
    }

    @Test
    void sendImgMail() throws MessagingException {
        String to = "weizhewu232623@gmail.com";
        String subject ="小傻子千万别打开";
        String content = "<h3>大大的小傻子</h3><br/><img src=\"cid:img01\"/";
        String imgPath = "D:\\1.png";
        Map<String,String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }
}