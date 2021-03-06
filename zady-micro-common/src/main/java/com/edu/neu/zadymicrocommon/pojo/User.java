package com.edu.neu.zadymicrocommon.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class User {

    @TableId
    private Integer userId;

    @NotBlank
    private String name;

    @Email
    private String email;

    @URL
    private String avatar;

    // todo: 这个字段不能返回
    private String password;

    private Integer defaultProjectId;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private Role role;
}
