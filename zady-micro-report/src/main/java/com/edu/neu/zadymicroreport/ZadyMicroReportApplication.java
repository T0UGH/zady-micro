package com.edu.neu.zadymicroreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages={"com.edu.neu"})
public class ZadyMicroReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadyMicroReportApplication.class, args);
    }

}
