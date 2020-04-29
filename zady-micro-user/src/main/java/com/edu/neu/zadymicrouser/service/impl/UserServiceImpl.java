package com.edu.neu.zadymicrouser.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.neu.zadymicrouser.mapper.UserMapper;
import com.edu.neu.zadymicrouser.pojo.User;
import com.edu.neu.zadymicrouser.service.UserService;
import com.edu.neu.zadymicrouser.util.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Value("${zady.default-avatar}")
    private String defaultAvatar;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserMapper userMapper;


    @Override
    public Integer register(User user) {
        logger.debug("Creating user: " + user.getEmail());

        //密码进入数据库前加密
        String password = user.getPassword();
        String encryptPassword = Encoder.string2Sha1(password);

        user.setPassword(encryptPassword);

        if(user.getAvatar() == null){
            user.setAvatar(defaultAvatar);
        }

        return userMapper.insert(user);
    }

}
