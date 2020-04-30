package com.edu.neu.zadymicrouser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.neu.zadymicrocommon.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

    @Update("UPDATE project SET current_sprint_id = null WHERE project_id = #{projectId}")
    Integer updateCurrentSprintIdToNull(Integer projectId);
}
