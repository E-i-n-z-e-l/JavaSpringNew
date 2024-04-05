package com.example.Practical_09_ApiGatewayBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practical09ApiGatewayBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practical09ApiGatewayBookApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("FirstBook", r -> r.path("/serviceA/**")
                        .uri("http://localhost:8081/"))
                .route("SecondBook", r -> r.path("/serviceB/**")
                        .uri("http://localhost:8082/")).build();
    }

}
