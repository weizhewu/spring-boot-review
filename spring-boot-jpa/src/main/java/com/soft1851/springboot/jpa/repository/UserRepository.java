package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/5/13 7:51
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据方法名解析：按userName和password相等查询唯一记录
     *
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameEqualsAndPasswordEquals(String userName, String password);

    /**
     * 根据方法名解析：按nickName模糊查询一组记录
     *
     * @param nickName
     * @return
     */
    List<User> findUsersByNickNameLike(String nickName);

    /**
     * 根据方法名解析：查询年龄大于指定age的所有用户
     * @param age
     * @return
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return User
     */
    User findByUserName(String userName);

    /**
     * 关键字查询用户
     * @param username
     * @param email
     * @return List<User>
     */
    List<User> findByUserNameOrEmail(String username,String email);

    /**
     *
     * @param id
     * @return
     */
//    Long deleteById(Long id);

    /**
     * 根据用户名统计
     * @param userName
     * @return
     */
    Long countByUserName(String userName);

    /**
     * 根据邮箱模糊查询用户
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);

    /**
     * 根据用户名查询用户，忽略大小写
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);

    /**
     * 根据用户名查询用户，根据邮箱降序
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);



}
