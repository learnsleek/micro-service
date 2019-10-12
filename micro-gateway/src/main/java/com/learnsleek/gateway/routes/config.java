package com.learnsleek.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/entity/**")
                        .filters(f-> f.addRequestHeader(
                                "Test", "Added New Header")
                                .hystrix(config -> config.setName("entity"))
                        )
                        .uri("lb://core-service/")
                        .id("core-entity"))
                .route(r -> r.path("/core/**")
                        .filters(f -> f.hystrix(config -> config.setName("core")))
                        .uri("lb://func-service/")
                        .id("func-service"))
                .build();
    }

}