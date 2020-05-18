package com.soft1851.springboot.quartz.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @Author: zw_w
 * @Date: 2020/5/18 20:07
 * @Description: 修改cron表达式的dto类
 */
@Data
public class ModifyCronDto {
    @NotNull(message = "the job id cannot be null")
    private Integer id;

    @NotEmpty(message = "the cron cannot be empty")
    private String cron;
}
