package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 18:08
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return User
     */
    User findByUserName(String userName);

    @Query(value = "SELECT * FROM user WHERE MONTH(reg_time) = MONTH(NOW()) AND DAY(reg_time) = DAY(NOW())",nativeQuery = true)
    List<User> findUsersByBirthday();
}
