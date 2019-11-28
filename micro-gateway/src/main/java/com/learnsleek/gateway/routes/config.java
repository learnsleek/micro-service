package com.learnsleek.gateway.routes;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/core/**")
                        .filters(f -> f.hystrix(config -> config.setName("core")))
                        .uri("lb://func-services/")
                        .id("func-service"))
                .route(r -> r.path("/entity/get/**")
                        .uri("lb://core-services/")
                        .id("core-services"))
                .route(r -> r.path("/entity/get1/**")
                        .uri("lb://core-services/"))
                //.route(r -> r.path("/test").filters(f -> f.addRequestHeader()).uri("").id(""))
                .build();
    }

}

      /* .route(r -> r.path("/entity/**")
                        .filters(f-> f.addRequestHeader(
                                "Test", "Added New Header")
                                .hystrix(config -> config.setName("entity"))
                        )
                        .uri("lb://core-service/")
                        .id("core-entity"))*/