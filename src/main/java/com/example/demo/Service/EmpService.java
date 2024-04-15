package com.example.demo.Service;

import com.example.demo.Entity.Emp;
import com.example.demo.Entity.PageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {


    PageBean getPageDataCondition(Integer pageNumber,
                                  Integer pageSize,
                                  String name, Short gender,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);

    void updateEmp(Emp emp);
}
