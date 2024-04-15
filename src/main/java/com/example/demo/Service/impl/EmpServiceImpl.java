package com.example.demo.Service.impl;

import com.example.demo.Entity.Emp;
import com.example.demo.Entity.PageBean;
import com.example.demo.Mapper.EmpMapper;
import com.example.demo.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean getPageDataCondition(Integer pageNumber,
                                         Integer pageSize,
                                         String name, Short gender,
                                         LocalDateTime startTime,
                                         LocalDateTime endTime) {
        Long start = (long) ((pageNumber - 1) * pageSize);
        List<Emp> empList =empMapper.getPageDataCondition(start, pageSize, name, gender, startTime, endTime);
        return new PageBean((long) empList.size(), empList);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void insertEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

}
