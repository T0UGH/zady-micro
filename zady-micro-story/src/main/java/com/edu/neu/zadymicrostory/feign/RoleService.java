package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.Project;
import com.edu.neu.zadymicrocommon.pojo.Role;
import com.edu.neu.zadymicrocommon.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 处理人员和项目之间的关系的服务
 * */
@FeignClient(value = "service-user", fallbackFactory = DefaultFallBackFactory.class)
public interface RoleService {

    /**
     * 根据id获取Role
     * */
    @GetMapping("/role/id/{roleId}")
    Role selectById(@PathVariable Integer id);


    /**
     * 根据projectId和userId获取Role
     * */
    @GetMapping("/role")
    Role selectByPIdAndUId(Integer projectId, Integer userId);

}
