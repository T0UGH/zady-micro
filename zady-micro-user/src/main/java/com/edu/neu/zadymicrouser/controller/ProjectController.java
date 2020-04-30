package com.edu.neu.zadymicrouser.controller;

import com.edu.neu.zadymicrocommon.annotation.Auth;
import com.edu.neu.zadymicrocommon.exception.DefaultException;
import com.edu.neu.zadymicrocommon.exception.NoAuthException;
import com.edu.neu.zadymicrocommon.exception.NotFoundException;
import com.edu.neu.zadymicrocommon.pojo.Project;
import com.edu.neu.zadymicrocommon.pojo.Role;
import com.edu.neu.zadymicrouser.service.ProjectService;
import com.edu.neu.zadymicrocommon.util.ParamHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ProjectController {

    @Resource
    ProjectService projectService;

    @Auth(needProject = false)
    @PostMapping("/project")
    public Integer createProject(@RequestBody Project project){
        Integer currUserId = ParamHolder.getCurrentUserId();
        Integer rv = projectService.insert(project, currUserId);
        if(rv == 0){
            throw new DefaultException("创建项目失败");
        }
        return rv;
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master})
    @PutMapping("/project")
    public Integer updateProject(@RequestBody Project project){
        if(!ParamHolder.sameProject(project.getProjectId())){
            throw new NoAuthException("无权操作此项目");
        }
        Integer rv = projectService.update(project);
        if(rv == 0){
            throw new DefaultException("更改失败");
        }
        return rv;
    }

    @Auth(needProject = false)
    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable Integer projectId){
        Project project = projectService.selectById(projectId);
        if(project == null){
            throw new NotFoundException("无此工程");
        }
        return project;
    }
}
