package com.edu.neu.zadymicroreport.controller;

import com.edu.neu.zadymicroreport.service.BornoutService;
import com.edu.neu.zadymicroreport.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EchoController {

    @Resource
    private UserService userService;

    @Resource
    private BornoutService bornoutService;

    @GetMapping("/report/echo/{content}")
    public String echo(@PathVariable String content){
        return userService.echo(content);
    }

    @GetMapping("/report/testCommit")
    public Integer echo2(){
        return bornoutService.testCommit();
    }

    @GetMapping("/report/testRollback")
    public Integer echo3(){
        return bornoutService.testRollback();
    }
}
