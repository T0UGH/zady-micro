package com.edu.neu.zadymicroreport.service;

import com.edu.neu.zadymicrocommon.pojo.Bornout;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface BornoutService {

    List<Bornout> selectBySprint(Integer sprintId);

    Integer addBornout(Integer sprintId, Date createDate);

}
