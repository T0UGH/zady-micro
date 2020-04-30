package com.edu.neu.zadymicrostory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.neu.zadymicrocommon.pojo.Story;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoryMapper extends BaseMapper<Story> {

    @Update(("UPDATE story SET developer_id = null, status = '待完成' WHERE story_id = #{storyId}"))
    Integer developReturn(Integer storyId);

    @Update(("UPDATE story SET tester_id = null, status = '待测试' WHERE story_id = #{storyId}"))
    Integer testReturn(Integer storyId);
}
