package com.soft1851.springboot.task.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 21:38
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_name",nullable = false,length = 50)
    private String taskName;

    @Column(name = "clock_time",nullable = false,length = 50)
    private String clockTime;
}
