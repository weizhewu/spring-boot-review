package com.soft1851.springboot.task.schedule.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 11:28
 * @Description:
 */
public class JasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密盐
        textEncryptor.setPassword("232623");
        //加密数据
        String password = textEncryptor.encrypt("root");
        System.out.println(password);
    }
}
