package com.edu.neu.zadymicroreport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.neu.zadymicroreport.mapper.BornoutMapper;
import com.edu.neu.zadymicrocommon.pojo.Bornout;
import com.edu.neu.zadymicroreport.service.BornoutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BornoutServiceImpl implements BornoutService {

    @Resource
    BornoutMapper bornoutMapper;

    @Override
    public List<Bornout> selectBySprint(Integer sprintId) {

        LambdaQueryWrapper<Bornout> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Bornout::getSprintId, sprintId);

        return bornoutMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public Integer addBornout(Integer sprintId, Date createDate) {
        //先查有没有，没有则新建，有则更新加数

        LambdaQueryWrapper<Bornout> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Bornout::getSprintId, sprintId).eq(Bornout::getCreateDate, createDate);



        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createDateStr = dateFormat.format(createDate);

        Bornout bornout = bornoutMapper.selectBySprintAndDate(sprintId, createDateStr);

        if(bornout == null){
            bornout = new Bornout();
            bornout.setSprintId(sprintId);
            bornout.setCreateDate(createDate);
            bornout.setFinishedStoryNum(1);
            return bornoutMapper.insert(bornout);
        }else{
            bornout.setFinishedStoryNum(bornout.getFinishedStoryNum() + 1);
            return bornoutMapper.updateById(bornout);
        }

    }

}
