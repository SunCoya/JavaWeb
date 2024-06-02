package com.example.springbootdemo4aop.mvc;
import com.example.springbootdemo4aop.pojo.Dept;
import com.example.springbootdemo4aop.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    DeptService deptService;
    @GetMapping
    public Result selectAll(){
        log.info("查询全部部门数据");
        return Result.success(deptService.selectAll());
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除部门id："+id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("新增部门："+dept.getName());
        deptService.insert(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查找部门："+id);
        return Result.success(deptService.selectById(id));
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门："+dept.getId()+dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
