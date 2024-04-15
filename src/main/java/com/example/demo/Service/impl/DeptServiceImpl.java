package com.example.demo.Service.impl;

import com.example.demo.Entity.Dept;
import com.example.demo.Mapper.DeptMapper;
import com.example.demo.Mapper.EmpMapper;
import com.example.demo.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    public List<Dept> getAllDepts(){
        return deptMapper.getAllDepts();
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED) //开启事务管理
    public void deleteById(Integer id){
        deptMapper.deleteById(id);
        empMapper.deleteByDept(id);
    }

    public void addDept(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.addDept(dept);}
}
