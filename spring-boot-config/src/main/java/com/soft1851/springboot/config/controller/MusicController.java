package com.soft1851.springboot.config.controller;

import com.soft1851.springboot.config.module.Music;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/5/12 17:09
 * @Description:
 */
@RestController
@Slf4j
public class MusicController {
    @Resource
    private Music music;

    @Value("${music.name}")
    private String name;

    @GetMapping("/music")
    public Music music() {
        log.info(String.valueOf(music));
        log.info(name);
        return music;
    }

}
