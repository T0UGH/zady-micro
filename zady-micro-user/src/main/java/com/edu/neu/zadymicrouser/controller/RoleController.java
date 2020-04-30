package com.edu.neu.zadymicrouser.controller;

import com.edu.neu.zadymicrocommon.annotation.Auth;
import com.edu.neu.zadymicrocommon.exception.BadDataException;
import com.edu.neu.zadymicrocommon.exception.DefaultException;
import com.edu.neu.zadymicrocommon.exception.NoAuthException;
import com.edu.neu.zadymicrocommon.exception.NotFoundException;
import com.edu.neu.zadymicrocommon.pojo.Project;
import com.edu.neu.zadymicrocommon.pojo.Role;
import com.edu.neu.zadymicrocommon.pojo.User;
import com.edu.neu.zadymicrouser.service.RoleService;
import com.edu.neu.zadymicrocommon.util.ParamHolder;
import com.edu.neu.zadymicrocommon.util.RoleValidator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

    @Resource
    RoleService roleService;

    @PostMapping("/role")
    @Auth(role = {Role.RoleEnum.master}, sameProject = true)
    public Integer inviteUser(Integer projectId, Integer userId, String role){
        if(!RoleValidator.validate(role)){
            throw new BadDataException("角色信息格式错误");
        }

        Integer rv = roleService.inviteUser(projectId, userId, role);

        if( rv == 0){
            throw new DefaultException("角色创建失败");
        }

        return rv;
    }

    @PutMapping("/invite/{projectId}")
    @Auth(needProject = false)
    public Integer acceptInvite(@PathVariable Integer projectId){
        Integer currUserId = ParamHolder.getCurrentUserId();

        if(currUserId == null){
            throw new DefaultException("用户ID错误");
        }

        Integer rv = roleService.joinProject(projectId, currUserId);

        if(rv == 0){
            throw new DefaultException("接受邀请失败");
        }

        return rv;
    }

    @PutMapping("/role")
    @Auth(role = {Role.RoleEnum.master}, sameProject = true)
    public Integer updateRole(Integer projectId, Integer userId, String role){

        Integer rv = roleService.updateByPIdAndUId(projectId, userId, role);

       if( rv == 0){
           throw new DefaultException("更新失败");
       }

       return rv;
    }

    @DeleteMapping("/role")
    @Auth(role = {Role.RoleEnum.master}, sameProject = true)
    public Integer deleteRole(Integer projectId, Integer userId){

        Integer rv = roleService.deleteUser(projectId, userId);

        if(rv == 0){
            throw new DefaultException("删除失败");
        }

        return rv;
    }

    @GetMapping("/role")
    @Auth(needProject = false)
    public Role getRole(Integer projectId, Integer userId){
        Role role = roleService.selectByPIdAndUId(projectId, userId);
        if(role == null){
            throw new NotFoundException("获取失败");
        }
        return role;
    }

    @GetMapping("/user/projects/{userId}")
    @Auth(needProject = false)
    public List<Project> getProjectsByUser(@PathVariable Integer userId){
        return roleService.selectProjectsByUId(userId);
    }

    @GetMapping("/user/invites/{userId}")
    @Auth(needProject = false)
    public List<Project> getInviteProjectsByUser(@PathVariable Integer userId){
        return roleService.selectInviteProjectsByUId(userId);
    }

    @GetMapping("/project/users/{projectId}")
    @Auth(sameProject = true, role = {Role.RoleEnum.master})
    public List<User> getUsersByProject(@PathVariable Integer projectId){
        if(!ParamHolder.sameProject(projectId)){
            throw new NoAuthException("无当前项目权限");
        }
        return roleService.selectUsersByPId(projectId);
    }

    @GetMapping("/project/invites/{projectId}")
    @Auth(sameProject = true, role = {Role.RoleEnum.master})
    public List<User> getInviteUsersByProject(@PathVariable Integer projectId){
        if(!ParamHolder.sameProject(projectId)){
            throw new NoAuthException("无当前项目权限");
        }
        return roleService.selectInviteUsersByPId(projectId);
    }

}
