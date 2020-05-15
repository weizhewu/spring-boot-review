package com.soft1851.springboot.task.schedule.dao;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 15:13
 * @Description:
 */
public interface MailService {
    /**
     * 发送简单的文本邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleTextMail(String to,String subject,String content);

    /**
     * 发送HTML格式邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws MessagingException
     */
    void sendHtmlMail(String to,String subject,String content) throws MessagingException;



    /**
     * 发送附件邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param fileArr 文件路径
     * @throws MessagingException
     */
    void sendAttachmentMail(String to,String subject,String content ,String...fileArr) throws MessagingException;


    /**
     * 发送附件邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param imgMap 图片
     * @throws MessagingException
     */
    void sendImgMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;
}
