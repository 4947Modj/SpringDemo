package com.example.demo.Controller;

import com.example.demo.Entity.Dept;
import com.example.demo.Entity.Result;
import com.example.demo.Service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@CrossOrigin  //解决跨域问题
public class DeptController {
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /*
    * 查询全部部门信息
    * */
    //@GetMapping("/depts")效果是一样的
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result getAllDept(){
        List<Dept> list = deptService.getAllDepts();
        return Result.success(list);
    }


    /*
    *
    * */
    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id){
        deptService.deleteById(id);
        return Result.success();
    }

    /*
    * 添加部门信息
    * */
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        //@RequestBody 作用: 将前台发送的JSON数据，转换为后台的实体类对象
        log.info("新增部门: {}",dept);
        deptService.addDept(dept);
        return Result.success();
    }


}
