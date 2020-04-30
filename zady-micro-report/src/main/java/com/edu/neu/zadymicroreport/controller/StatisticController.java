package com.edu.neu.zadymicroreport.controller;

import com.edu.neu.zadymicrocommon.annotation.Auth;
import com.edu.neu.zadymicrocommon.exception.NotFoundException;
import com.edu.neu.zadymicrocommon.pojo.Bornout;
import com.edu.neu.zadymicrocommon.pojo.DashBoard;
import com.edu.neu.zadymicrocommon.pojo.Role;
import com.edu.neu.zadymicroreport.service.BornoutService;
import com.edu.neu.zadymicroreport.service.DashBoardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class StatisticController {

    @Resource
    DashBoardService dashBoardService;

    @Resource
    BornoutService bornoutService;

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @GetMapping("/dashBoard/project/{projectId}")
    public DashBoard getDashBoardByProject(@PathVariable Integer projectId) {

        DashBoard dashBoard = dashBoardService.selectByProject(projectId);

        if(dashBoard == null){
            throw new NotFoundException("给定project[" + projectId +"]对应dashboard未找到");
        }

        return dashBoard;

    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @GetMapping("dashBoard/sprint/{sprintId}")
    public DashBoard getDashBoardBySprint(@PathVariable Integer sprintId) {

        DashBoard dashBoard = dashBoardService.selectBySprint(sprintId);

        if(dashBoard == null){
            throw new NotFoundException("给定sprint[" + sprintId +"]对应dashboard未找到");
        }

        return dashBoard;

    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @GetMapping("bornout/sprint/{sprintId}")
    public List<Bornout> getBornoutBySprint(@PathVariable Integer sprintId) {

        List<Bornout> bornoutList = bornoutService.selectBySprint(sprintId);

        if(bornoutList == null){
            throw new NotFoundException("给定sprint[" + sprintId +"]对应bornout未找到");
        }

        return bornoutList;

    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PostMapping("bornout")
    Integer addBornout(Integer sprintId, Date createDate){
        return bornoutService.addBornout(sprintId, createDate);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PostMapping("dashboard/{sprintId}")
    public Integer insert(@PathVariable Integer sprintId){
        return dashBoardService.insert(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/backlogNum/add/{sprintId}")
    public Integer addBacklogNum(@PathVariable Integer sprintId){
        return dashBoardService.addBacklogNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/backlogNum/sub/{sprintId}")
    public Integer subBacklogNum(@PathVariable Integer sprintId){
        return dashBoardService.subBacklogNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/finishedBacklogNum/add/{sprintId}")
    public Integer addFinishedBacklogNum(@PathVariable Integer sprintId){
        return dashBoardService.addFinishedBacklogNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/storyNum/add/{sprintId}")
    public Integer addStoryNum(@PathVariable Integer sprintId){
        return dashBoardService.addStoryNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/storyNum/sub/{sprintId}")
    public Integer subStoryNum(@PathVariable Integer sprintId){
        return dashBoardService.subStoryNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/inTimeStoryNum/add/{sprintId}")
    public Integer addInTimeStoryNum(@PathVariable Integer sprintId){
        return dashBoardService.addInTimeStoryNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/outTimeStoryNum/add/{sprintId}")
    public Integer addOutTimeStoryNum(@PathVariable Integer sprintId){
        return dashBoardService.addOutTimeStoryNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/bugNum/add/{sprintId}")
    public Integer addBugNum(@PathVariable Integer sprintId){
        return dashBoardService.addBugNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/bugNum/sub/{sprintId}")
    public Integer subBugNum(@PathVariable Integer sprintId){
        return dashBoardService.subStoryNum(sprintId);
    }

    @Auth(sameProject = true, role = {Role.RoleEnum.master, Role.RoleEnum.owner, Role.RoleEnum.developer, Role.RoleEnum.tester})
    @PutMapping("dashboard/solvedBugNum/add/{sprintId}")
    public Integer addSolvedBugNum(@PathVariable Integer sprintId){
        return dashBoardService.addSolvedBugNum(sprintId);
    }
}
