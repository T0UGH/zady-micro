package com.edu.neu.zadymicroreport.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.Sprint;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "service-story", fallbackFactory = DefaultFallBackFactory.class)
public interface SprintService {

    @GetMapping("/sprint/{sprintId}")
    Sprint selectById(@PathVariable Integer sprintId);

}
