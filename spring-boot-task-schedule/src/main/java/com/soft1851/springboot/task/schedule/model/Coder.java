package com.soft1851.springboot.task.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 19:11
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * 主页地址
     */
    @Column(nullable = false, length = 200)
    private String url;

    /**
     * 头像
     */
    @Column(nullable = false, length = 200)
    private String avatar;

}
