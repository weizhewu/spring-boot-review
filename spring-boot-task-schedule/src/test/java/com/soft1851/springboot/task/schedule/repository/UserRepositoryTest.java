package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 18:09
 * @Description:
 */
@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
        LocalDate birthday = userRepository.findByUserName("user1").getRegTime().toLocalDate();
        LocalDate now = LocalDate.now();
        if (birthday.equals(now)){

        }
    }

    @Test
    void findByBirthdayLike() {
        List<User> users = userRepository.findUsersByBirthday();
        users.forEach(user -> System.out.println(user.getNickName()));
    }
}