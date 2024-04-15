package com.example.demo.Controller;

import com.example.demo.AOP.MyLog;
import com.example.demo.Entity.Emp;
import com.example.demo.Entity.PageBean;
import com.example.demo.Entity.Result;
import com.example.demo.Service.DeptService;
import com.example.demo.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
//@CrossOrigin
public class EmpController {

    @Autowired
    EmpService empService;

    @MyLog
    @GetMapping("/emps")
    public Result getPageDataCondition(@RequestParam(defaultValue = "1") Integer pageNumber,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       String name, Short gender,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime startTime,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime endTime){
        //@RequestParam 获取查询参数数据,设置默认值
        PageBean pageBean = empService.getPageDataCondition(pageNumber,pageSize,name,gender,startTime,endTime);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result deleteEmpByIds(@PathVariable List<Integer> ids){
        //@PathVariable 获取路径{ids}数据转换成数组ids
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result insertEmp(@RequestBody Emp emp){
        //@RequestBody 获取请求体数据转换成对象emp
        empService.insertEmp(emp);
        return Result.success();
    }

    @PutMapping("emps")
    public Result updateEmp(@RequestBody Emp emp){
        //@PathVariable 获取路径{id}数据转换成int id
        //@RequestBody 获取请求体数据转换成对象emp
        empService.updateEmp(emp);
        return Result.success();
    }
}
