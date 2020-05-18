package com.soft1851.springboot.task.schedule.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zw_w
 * @Date: 2020/5/18 17:50
 * @Description: 定时器任务工具类
 */
public class QuartzCronDateUtil {
    /**
     * 转化日期格式
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String timeStr = null;
        if (date != null){
            timeStr = sdf.format(date);
        }
        return timeStr;
    }

    /**
     * 日期转化corn表达式时间格式
     * @param date
     * @return
     */
    public static String getCron(Date date){
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date,dateFormat);
    }
}
