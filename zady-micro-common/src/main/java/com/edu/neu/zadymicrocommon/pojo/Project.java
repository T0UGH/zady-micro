package com.edu.neu.zadymicrocommon.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
public class Project {

    @TableId
    @JsonProperty(value = "projectId")
    private Integer projectId;

    @NotBlank
    private String name;

    private String note;

    @URL
    private String githubUrl;

    private Integer masterId;

    private Integer sprintNum;

    private Integer currentSprintId;

    @TableField(exist = false)
    private Role role;
}
