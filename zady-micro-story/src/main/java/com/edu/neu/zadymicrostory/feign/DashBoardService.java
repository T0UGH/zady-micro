package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.DashBoard;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-report", fallbackFactory = DefaultFallBackFactory.class)
public interface DashBoardService {

    Integer insert(Integer sprintId);

    DashBoard selectBySprint(Integer sprintId);

    DashBoard selectByProject(Integer projectId);

    Integer addBacklogNum(Integer sprintId);

    Integer subBacklogNum(Integer sprintId);

    Integer addFinishedBacklogNum(Integer sprintId);

    Integer addStoryNum(Integer sprintId);

    Integer subStoryNum(Integer sprintId);

    Integer addInTimeStoryNum(Integer sprintId);

    Integer addOutTimeStoryNum(Integer sprintId);

    Integer addBugNum(Integer sprintId);

    Integer subBugNum(Integer sprintId);

    Integer addSolvedBugNum(Integer sprintId);

}
