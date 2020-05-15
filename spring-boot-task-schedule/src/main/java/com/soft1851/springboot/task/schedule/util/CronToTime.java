package com.soft1851.springboot.task.schedule.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 21:50
 * @Description:
 */
public class CronToTime {
    public static Date getDate(String cron) {
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        Date date = null;
        try {
            date = sdf.parse(cron);

        } catch (ParseException e) {
            return null;// 此处缺少异常处理,自己根据需要添加
        }
        return date;
    }
    public static String getCorn(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    public static String getStringDate(String cron){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy年MM月dd hh:mm:ss");
        return sdf.format(CronToTime.getDate(cron));
    }


    public static void main(String[] args) {


        String cron = "20 28 17 02 08 ? 2016";

        Date cronDate = CronToTime.getDate(cron);
        System.out.println(cronDate);
        System.out.println(CronToTime.getStringDate(cron));

        System.out.println(CronToTime.getCorn(Date.from(LocalDateTime.now()
        .atZone(ZoneId.systemDefault()).toInstant())));


    }
}
