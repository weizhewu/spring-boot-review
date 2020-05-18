package com.soft1851.springboot.task.schedule.config;

import com.soft1851.springboot.task.schedule.filter.TrustedEndpointsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 23:04
 * @Description:
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 内部端口
    @Value("${server.trustedPort}")
    private String trustedPort;

    // 内部接口 URL 路径前缀
    @Value("${server.trustedPathPrefix}")
    private String trustedPathPrefix;

    @Bean
    public FilterRegistrationBean<TrustedEndpointsFilter> trustedEndpointsFilter() {
        return new FilterRegistrationBean<>(new TrustedEndpointsFilter(trustedPort, trustedPathPrefix));
    }
}
