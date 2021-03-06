package com.edu.neu.zadymicrocommon.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public class Story {

    @TableId
    private Integer storyId;

    private Integer projectId;

    private Integer sprintId;

    private Integer backlogId;

    private Status status;

    private String name;

    private Integer expectedHours;

    private Integer currentHours;

    private Date createdDate;

    private Date finishedDate;

    private Integer developerId;

    private Integer testerId;

    @TableLogic
    private Boolean flag;

    public enum Status {
        待导入, 待完成, 完成中, 待测试, 测试中, 已完成
    }
}
