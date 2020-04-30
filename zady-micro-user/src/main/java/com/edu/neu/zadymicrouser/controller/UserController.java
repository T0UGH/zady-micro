package com.edu.neu.zadymicrouser.controller;

import com.edu.neu.zadymicrocommon.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册
     * */
    @PostMapping("/user")
    public Integer register(@RequestBody User user){
        int rv = userService.register(user);
        if(rv == 0){
            throw new RuntimeException("注册失败");
        }else{
            return rv;
        }
    }

}
