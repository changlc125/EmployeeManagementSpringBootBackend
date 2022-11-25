package com.example.applicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServiceApplication.class, args);
    }

}
