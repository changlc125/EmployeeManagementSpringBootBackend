package com.example.housingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HousingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingServiceApplication.class, args);
    }

}
