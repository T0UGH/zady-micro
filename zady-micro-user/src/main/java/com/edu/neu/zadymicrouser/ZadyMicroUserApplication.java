package com.edu.neu.zadymicrouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ZadyMicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadyMicroUserApplication.class, args);
    }

    @RestController
    class EchoController {
        @RequestMapping(value = "user/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) throws InterruptedException {
            Thread.sleep(20);
            return "Hello Nacos Discovery " + string;
        }

        @RequestMapping(value = "role/echo/{string}", method = RequestMethod.GET)
        public String echo2(@PathVariable String string) throws InterruptedException {
            Thread.sleep(20);
            return "Hello Nacos Discovery2 " + string;
        }
    }

}
