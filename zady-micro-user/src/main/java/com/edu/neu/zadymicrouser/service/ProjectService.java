package com.edu.neu.zadymicrouser.service;

import com.edu.neu.zadymicrocommon.pojo.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

    Project selectById(Integer id);

    Boolean existById(Integer id);

    Integer insert(Project project, Integer currentUserId);

    Integer update(Project project);

    Integer updateCurrentSprintId(Integer projectId, Integer currentSprintId);

    Integer addSprintNum(Integer projectId);

    Integer updateCurrentSprintIdAndAddSprintNum(Integer projectId, Integer currentSprintId);

    Integer updateCurrentSprintIdToNull(Integer projectId);
}
