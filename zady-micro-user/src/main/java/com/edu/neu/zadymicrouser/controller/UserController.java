package com.edu.neu.zadymicrouser.controller;

import com.edu.neu.zadymicrocommon.annotation.Auth;
import com.edu.neu.zadymicrocommon.exception.DefaultException;
import com.edu.neu.zadymicrocommon.exception.NoAuthException;
import com.edu.neu.zadymicrocommon.exception.NotFoundException;
import com.edu.neu.zadymicrocommon.pojo.User;
import com.edu.neu.zadymicrouser.service.UserService;
import com.edu.neu.zadymicrocommon.util.ParamHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册
     * */
    @PostMapping("/user")
    public String register(@RequestBody User user){
        if(userService.register(user) == 0){
            throw new DefaultException("注册失败");
        }else{
            return "注册成功";
        }
    }

    /**
     * 检测邮箱是否被使用了
     * */
    @GetMapping("/user/exist/email/{email}")
    public Boolean existByEmail(@PathVariable String email){
        return userService.existByEmail(email);
    }

    /**
     * 检测对应id的用户是否存在
     * */
    @GetMapping("/user/exist/{userId}")
    public Boolean existByUserId(@PathVariable Integer userId){
        return userService.existById(userId);
    }

    /**
     * 读取某个用户的信息
     * */
    @Auth(needProject = false)
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Integer userId){
        User user =  userService.selectById(userId);
        if(user == null){
            throw new NotFoundException("用户不存在");
        }
        return user;
    }

    /**
     * 根据用户的email读取某个用户的信息
     * */
    @Auth(needProject = false)
    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user =  userService.selectByEmail(email);
        if(user == null){
            throw new NotFoundException("用户不存在");
        }
        return user;
    }

    /**
     * 通过某个关键词搜索用户
     * */
    @Auth(needProject = false)
    @GetMapping("/users/{queryStr}")
    public List<User> getUsers(@PathVariable String queryStr){

        return userService.selectByQueryStr(queryStr);
    }

    /**
     * 通过某个关键词搜索用户并且屏蔽掉已经加入的角色
     * */
    @Auth(needProject = true, sameProject = true)
    @GetMapping("/usersForInvite")
    public List<User> getUsersForInvite(String queryStr, Integer projectId){
        return userService.selectForInviteByQueryStr(queryStr, projectId);
    }


    /**
     * 用户修改自己的基本信息
     * */
    @Auth(needProject = false, sameUser = true)
    @PutMapping("/user")
    public String updateUser(@RequestBody User user){

        if(!ParamHolder.sameUser(user.getUserId())){
            throw new NoAuthException("不能修改其他用户的个人信息");
        }

        if(userService.update(user) == 0){
            throw new DefaultException("更新失败");
        }
        return "更新成功";
    }
}
