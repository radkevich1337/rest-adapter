package com.example.gazpromtask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition
@EnableCaching
public class GazpromTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(GazpromTaskApplication.class, args);
    }

}
