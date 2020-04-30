package com.edu.neu.zadymicrostory.feign;

import com.edu.neu.zadymicrocommon.feign.DefaultFallBackFactory;
import com.edu.neu.zadymicrocommon.pojo.Bornout;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Date;
import java.util.List;

@FeignClient(value = "service-report", fallbackFactory = DefaultFallBackFactory.class)
public interface BornoutService {

    List<Bornout> selectBySprint(Integer sprintId);

    Integer addBornout(Integer sprintId, Date createDate);

}
