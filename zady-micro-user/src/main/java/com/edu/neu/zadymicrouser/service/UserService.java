package com.edu.neu.zadymicrouser.service;

import com.edu.neu.zadymicrouser.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {

    Integer register(@RequestBody User user);

}
