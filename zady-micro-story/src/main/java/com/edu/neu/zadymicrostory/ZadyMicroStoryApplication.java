package com.edu.neu.zadymicrostory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.edu.neu"})
public class ZadyMicroStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadyMicroStoryApplication.class, args);
    }

}
