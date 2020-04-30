package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-user", fallbackFactory = DefaultFallBackFactory.class)
public interface UserService {

    @GetMapping("/user/{userId}")
    User selectById(@PathVariable Integer userId);

    @GetMapping("/user/email/{email}")
    User selectByEmail(@PathVariable String email);

    @GetMapping("/users/{queryStr}")
    List<User> selectByQueryStr(@PathVariable String queryStr);

    @PutMapping("/user")
    Integer update(User user);

    @PostMapping("/user")
    Integer register(User user);

    @GetMapping("/user/exist/email/{email}")
    Boolean existByEmail(@PathVariable String email);

    @GetMapping("/user/exist/{userId}")
    Boolean existById(@PathVariable Integer userId);

    @GetMapping("/usersForInvite")
    List<User> selectForInviteByQueryStr(String queryStr, Integer projectId);
}
