package com.sedona.test.microservicespring.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
public class MicroserviceASpringApplication {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceASpringApplication.class, args);
    }

}

