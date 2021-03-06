package com.edu.neu.zadymicrostory.service;

import com.edu.neu.zadymicrocommon.pojo.Bug;

import java.util.List;

public interface BugService {

    Bug selectById(Integer bugId);

    List<Bug> selectBySprintId(Integer sprintId);

    List<Bug> selectBySprintIdAndStatus(Integer sprintId, String statusStr);

    List<Bug> selectByBacklogId(Integer backlogId);

    List<Bug> selectByBacklogIdAndStatus(Integer backlogId, String statusStr);

    List<Bug> selectByStoryId(Integer storyId);

    List<Bug> selectByStoryIdAndStatus(Integer storyId, String statusStr);

    Integer insert(Bug bug);

    Integer update(Bug bug);

    Integer delete(Integer bugId);

    Integer developNotConfirm(Integer bugId, Integer userId);

    Integer developConfirm(Integer bugId, Integer userId);

    Integer developFinish(Integer bugId, Integer userId);

    Integer testPass(Integer bugId, Integer userId);

    Integer testNotPass(Integer bugId, Integer userId);



}
