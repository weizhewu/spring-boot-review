package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/14 16:37
 * @Description:
 */
@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "clazz_name", nullable = false, length = 20)
    private String clazzName;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private List<Student> studentList;
}
