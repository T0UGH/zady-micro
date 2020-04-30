package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "service-user", fallbackFactory = DefaultFallBackFactory.class)
public interface ProjectService {

    @GetMapping("/project/{projectId}")
    Project selectById(@PathVariable Integer projectId);

    @GetMapping("/project/exist/{projectId}")
    Boolean existById(@PathVariable Integer projectId);

    @PostMapping("/project")
    Integer insert(Project project, Integer currentUserId);

    @PutMapping("/project")
    Integer update(Project project);

    @PutMapping("/project/sprintId")
    Integer updateCurrentSprintId(Integer projectId, Integer currentSprintId);

    @PutMapping("/project/sprintNum")
    Integer addSprintNum(Integer projectId);

    @PutMapping("/project/springId/springNum")
    Integer updateCurrentSprintIdAndAddSprintNum(Integer projectId, Integer currentSprintId);

    @PutMapping("/project/springId/null")
    Integer updateCurrentSprintIdToNull(Integer projectId);
}
