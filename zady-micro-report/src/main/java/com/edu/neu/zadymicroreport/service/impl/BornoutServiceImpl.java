package com.edu.neu.zadymicroreport.service.impl;

import com.edu.neu.zadymicroreport.mapper.BornoutMapper;
import com.edu.neu.zadymicroreport.pojo.Bornout;
import com.edu.neu.zadymicroreport.pojo.User;
import com.edu.neu.zadymicroreport.service.BornoutService;
import com.edu.neu.zadymicroreport.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class BornoutServiceImpl implements BornoutService {

    @Resource
    UserService userService;

    @Resource
    BornoutMapper bornoutMapper;

    @Transactional
    @GlobalTransactional
    @Override
    public Integer testCommit() {
        User user = new User();
        user.setEmail("lwx@neu.com");
        user.setName("lwx");
        user.setPassword("Neusoft123");
        int rv = userService.register(user);
        Bornout bornout = new Bornout();
        bornout.setBornoutId(1);
        bornout.setFinishedStoryNum(1);
        bornoutMapper.updateById(bornout);
        return rv;
    }

    @Transactional
    @GlobalTransactional
    @Override
    public Integer testRollback() {
        User user = new User();
        user.setEmail("lwx@neu.com");
        user.setName("lwx");
        user.setPassword("Neusoft123");
        int rv = userService.register(user);
        if(rv == 1){
            throw new RuntimeException("故意失败");
        }
        return rv;
    }
}
