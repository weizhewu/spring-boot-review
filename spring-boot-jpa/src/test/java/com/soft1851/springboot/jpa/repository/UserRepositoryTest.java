package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/5/13 15:13
 * @Description:
 */
@SpringBootTest
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    /**
     * 使用该save方法进行更新时会发现，更新全部字段时会正常实现，可是在只更新部分字段时，会发现没有更新的字段被置为null；
     */
    @Test
    void testSave(){
        List<User> userList = new ArrayList<>();
        for (int i = 0;i < 30 ; i++){
            User user= User.builder()
                    .userName("user"+i)
                    .email("11111"+i+"@qq.com")
                    .password("232623")
                    .nickName("name"+i)
                    .age(10+i)
                    .regTime(LocalDateTime.now())
                    .build();
            userList.add(user);
        }
        System.out.println(userRepository.saveAll(userList).size());

    }

    /**
     * 默认方法
     */
    @Test
    public void testBaseQuery() {
        System.out.println(userRepository.findAll().size());

        assertNotNull(userRepository.findById(1L).get().getAge());

//        User saveUser= User.builder()
//                .userName("测试")
//                .email("test")
//                .password("232623")
//                .nickName("test")
//                .age(10)
//                .regTime(LocalDateTime.now())
//                .build();
//        userRepository.save(saveUser);
//
//        User delUser = User.builder()
//                .userName("测试")
//                .email("test")
//                .password("232623")
//                .nickName("test")
//                .age(10)
//                .regTime(LocalDateTime.now())
//                .build();
//        userRepository.delete(delUser);

        userRepository.count();

        assert(userRepository.existsById(1l));

    }

    @Test
    void findByUserNameEqualsAndPasswordEquals() {
        User resultUser = userRepository.findByUserNameEqualsAndPasswordEquals("user1","232623");
        assertNotNull(resultUser.getId());

    }

    @Test
    void findUsersByNickNameLike() {
        List<User> userList = userRepository.findUsersByNickNameLike("name");
        userList.forEach(user -> System.out.println(user.getUserName()));
    }

    @Test
    void findUsersByAgeGreaterThan() {
        System.out.println(userRepository.findUsersByAgeGreaterThan(15).size());
    }

    @Test
    void findByUserName() {
        assertNotNull(userRepository.findByUserName("user1").getEmail());
    }

    @Test
    void findByUserNameOrEmail() {
        List<User> userList = userRepository.findByUserNameOrEmail("user","111111@qq.com");
        assertEquals(userList.size(),1);
    }

    @Test
    void countByUserName() {
        System.out.println(userRepository.countByUserName("user1"));
    }

    @Test
    void findByEmailLike() {
        System.out.println(userRepository.findByEmailLike("111111@qq.com").size());
    }


}