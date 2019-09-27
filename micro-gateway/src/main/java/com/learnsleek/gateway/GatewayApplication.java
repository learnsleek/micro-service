package com.learnsleek.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;

import reactor.core.publisher.Mono;


@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


}
