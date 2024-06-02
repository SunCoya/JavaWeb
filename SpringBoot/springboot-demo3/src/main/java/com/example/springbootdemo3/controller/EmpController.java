package com.example.springbootdemo3.controller;
import com.example.springbootdemo3.aop.Log;
import com.example.springbootdemo3.pojo.Emp;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/emps")
public class  EmpController {
    @Autowired
    EmpService empService;
    //通过注解给属性设置默认值,如此可以不传start与size
    @GetMapping
    public Result selectByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
            ){
        log.info("分页查询：第"+page+"页，"+size+"条数据");
        return Result.success(empService.selectByPage(page,size,name,gender,begin,end));
    }

    @Log
    //动态参数也能使用数组//集合的形式传入，在mybatis中的foreach标签也可
    @DeleteMapping("/{ids}")
    public Result deleteByIDs(@PathVariable Integer[] ids){
        log.info("根据id删除："+ Arrays.toString(ids));
        empService.deleteByIDs(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("插入数据："+emp);
        empService.insert(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查找员工："+id);
        return Result.success(empService.selectById(id));
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("根据id修改员工："+emp);
        empService.update(emp);
        return Result.success();
    }
}
