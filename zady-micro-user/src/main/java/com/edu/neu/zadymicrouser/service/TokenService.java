package com.edu.neu.zadymicrouser.service;


import com.edu.neu.zadymicrocommon.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    User login(String email, String password);

    String switchProject(Integer userId, Integer projectId);
}

