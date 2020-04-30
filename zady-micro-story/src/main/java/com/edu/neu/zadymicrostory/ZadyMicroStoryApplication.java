package com.edu.neu.zadymicrostory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.edu.neu"})
public class ZadyMicroStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadyMicroStoryApplication.class, args);
    }

}
