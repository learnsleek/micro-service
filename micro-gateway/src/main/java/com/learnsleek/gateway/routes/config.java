package com.learnsleek.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    //spring.cloud.gateway.routes[0].id=/entity
   //spring.cloud.gateway.routes[0].uri=lb://core-service/entity/
   //spring.cloud.gateway.routes[0].predicates[0]=Path=/entity/**


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/entity/**")
                        .uri("lb://core-service/entity/")
                        .id("core-service"))
                .build();
    }

}