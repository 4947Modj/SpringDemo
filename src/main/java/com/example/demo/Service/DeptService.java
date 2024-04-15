package com.example.demo.Service;

import com.example.demo.Entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getAllDepts();

    void deleteById(Integer id);

    void addDept(Dept dept);
}
