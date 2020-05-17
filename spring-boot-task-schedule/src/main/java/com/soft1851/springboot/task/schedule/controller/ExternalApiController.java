package com.soft1851.springboot.task.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 20:24
 * @Description:
 */
// 外部接口的 URL 路径以 /external/ 作为前缀
@Controller
public class ExternalApiController {
    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello stranger");
    }
}
