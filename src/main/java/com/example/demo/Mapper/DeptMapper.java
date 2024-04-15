package com.example.demo.Mapper;

import com.example.demo.Entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {


    // 添加部门

    // 删除部门

    // 修改部门

    // 查询部门
    List<Dept> getAllDepts();

    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);
}
