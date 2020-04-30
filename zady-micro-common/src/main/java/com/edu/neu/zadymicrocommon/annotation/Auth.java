package com.edu.neu.zadymicrocommon.annotation;

import com.edu.neu.zadymicrocommon.pojo.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    boolean needLogin() default true;
    boolean needProject() default true;
    boolean sameUser() default false;
    boolean sameProject() default false;
    Role.RoleEnum[] role() default {};
}
