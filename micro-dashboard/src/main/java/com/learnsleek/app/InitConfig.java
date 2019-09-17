package com.learnsleek.app;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

public class InitConfig {
    @Bean
    public WebClient.Builder getClient(){
        return WebClient.builder();
    }

    @Bean
    public RestTemplate getRestResult(){
        return new RestTemplate();
    }
}
