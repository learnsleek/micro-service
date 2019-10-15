package com.learnsleek.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class config {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
