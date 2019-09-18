package com.learnsleek.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InitConfig {
    @Bean
    public WebClient.Builder getClient(){
        return WebClient.builder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestResult(){
        return new RestTemplate();
    }
}
