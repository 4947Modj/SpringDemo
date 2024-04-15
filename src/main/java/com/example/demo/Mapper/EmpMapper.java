package com.example.demo.Mapper;

import com.example.demo.Entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    Emp getById(Integer id);

    Long getTotalScore();


    List<Emp> getPageDataCondition(Long start, Integer pageSize, String name, Short gender, LocalDateTime startTime, LocalDateTime endTime);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Emp emp);

    void updateEmp(Emp emp);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteByDept(Integer deptId);
}
