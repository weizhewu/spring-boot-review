package com.soft1851.springboot.task.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 20:32
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name = "corn_name",nullable = false,length = 30)
    private String cronName;

    @Column(name = "cron",nullable = false,length = 50)
    private String cron;
}
