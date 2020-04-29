package com.edu.neu.zadymicroreport.service;

import com.edu.neu.zadymicroreport.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.edu.neu.zadymicroreport.fallback.DefaultFallBackFactory;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "service-user", fallbackFactory = DefaultFallBackFactory.class)
public interface UserService {

    @GetMapping("/user/echo/{content}")
    String echo(@PathVariable String content);

    @PostMapping("/user")
    Integer register(User user);
}
