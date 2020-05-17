package com.soft1851.springboot.task.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zw_w
 * @Date: 2020/5/17 19:46
 * @Description:
 */
//@Configuration
public class RestTemplateConfig {

    @Autowired
    @Qualifier("OKSpringCommonsRestTemplate")
    ClientHttpRequestFactory okHttpRequestFactory;

    @Bean
    @Qualifier("OKSpringCommonsRestTemplate")
    public RestTemplate createOKCustomRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(okHttpRequestFactory);
        return restTemplate;
    }
}
