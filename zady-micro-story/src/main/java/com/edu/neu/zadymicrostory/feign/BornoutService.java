package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.Bornout;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@FeignClient(value = "service-report", fallbackFactory = DefaultFallBackFactory.class)
public interface BornoutService {

    @GetMapping("bornout/sprint/{sprintId}")
    List<Bornout> selectBySprint(@PathVariable Integer sprintId);

    @PostMapping("bornout")
    Integer addBornout(Integer sprintId, Date createDate);

}
