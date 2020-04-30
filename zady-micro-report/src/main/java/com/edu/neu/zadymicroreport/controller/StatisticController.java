package com.edu.neu.zadymicroreport.controller;

import com.edu.neu.zadymicrocommon.annotation.Auth;
import com.edu.neu.zadymicrocommon.exception.NotFoundException;
import com.edu.neu.zadymicrocommon.pojo.Bornout;
import com.edu.neu.zadymicrocommon.pojo.DashBoard;
import com.edu.neu.zadymicrocommon.pojo.Role;
import com.edu.neu.zadymicroreport.service.BornoutService;
import com.edu.neu.zadymicroreport.service.DashBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
