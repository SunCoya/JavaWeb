package com.example.springbootdemo3.controller;
import com.example.springbootdemo3.aop.Log;
import com.example.springbootdemo3.pojo.Dept;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.service.DeptService;
import com.example.springbootdemo3.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//直接调用log对象来记录日志（lombok包下的）
@Slf4j
@RestController
//在类上增加RequestMapping，表示这个类的所有路径前都需要加"/depts"，可以减少这个类里面地址的重复部分
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    DeptService deptService;
    EmpService empService;

    //指定请求方式RequestMethod为枚举类型
    //原本的指定路径方式：@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result selectAll(){
        //原本的获取日志方式：private static Logger log = LoggerFactory.getLogger(DeptController.class);
        log.info("查询全部部门数据");
        return Result.success(deptService.selectAll());
    }

    @Log
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除部门id："+id);
        deptService.deleteById(id);
        return Result.success();
    }

    @Log//aop编程注解
    @PostMapping
    //即使json只有一条数据，也用dept实体类封装
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

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门："+dept.getId()+dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
