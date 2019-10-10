package com.learnsleek.auth;

import com.learnsleek.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ComponentScan(basePackages = { "com.learnsleek"} )
@EnableEurekaClient
@EnableCircuitBreaker
@RibbonClient(name = "func-client", configuration = RibbonConfiguration.class)
@EnableResourceServer
public class FuncApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncApplication.class, args);
	}

}
