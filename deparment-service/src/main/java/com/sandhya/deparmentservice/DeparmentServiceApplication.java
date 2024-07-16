package com.sandhya.deparmentservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Department Service REST APIs", description = "Department Service REST API documentation", version = "v1.0"))
@SpringBootApplication
public class DeparmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeparmentServiceApplication.class, args);
    }

}
