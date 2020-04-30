package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.DashBoard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "service-report", fallbackFactory = DefaultFallBackFactory.class)
public interface DashBoardService {


    @PostMapping("dashboard/{sprintId}")
    Integer insert(@PathVariable Integer sprintId);

    @GetMapping("dashBoard/sprint/{sprintId}")
    DashBoard selectBySprint(@PathVariable Integer sprintId);

    @GetMapping("/dashBoard/project/{projectId}")
    DashBoard selectByProject(@PathVariable Integer projectId);

    @PutMapping("dashboard/backlogNum/add/{sprintId}")
    Integer addBacklogNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/backlogNum/sub/{sprintId}")
    Integer subBacklogNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/finishedBacklogNum/add/{sprintId}")
    Integer addFinishedBacklogNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/storyNum/add/{sprintId}")
    Integer addStoryNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/storyNum/sub/{sprintId}")
    Integer subStoryNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/inTimeStoryNum/add/{sprintId}")
    Integer addInTimeStoryNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/outTimeStoryNum/add/{sprintId}")
    Integer addOutTimeStoryNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/bugNum/add/{sprintId}")
    Integer addBugNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/bugNum/sub/{sprintId}")
    Integer subBugNum(@PathVariable Integer sprintId);

    @PutMapping("dashboard/solvedBugNum/add/{sprintId}")
    Integer addSolvedBugNum(@PathVariable Integer sprintId);

}
