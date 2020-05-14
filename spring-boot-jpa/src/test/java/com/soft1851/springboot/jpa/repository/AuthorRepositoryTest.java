package com.soft1851.springboot.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: zw_w
 * @Date: 2020/5/14 0:16
 * @Description:
 */
@SpringBootTest
@Slf4j
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findAuthorByIdEquals() {
        System.out.println(authorRepository.findAuthorByIdEquals(1L));
    }
}