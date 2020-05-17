package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 19:34
 * @Description:
 */
public interface CoderRepository extends JpaRepository<Coder,Integer> {
}
