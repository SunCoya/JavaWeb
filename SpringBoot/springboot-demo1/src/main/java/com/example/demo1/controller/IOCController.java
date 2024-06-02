package com.example.demo1.controller;

import com.example.demo1.pojo.Result;
import com.example.demo1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOCController {
    @Autowired
    EmpService empService;
    @RequestMapping("/listEmp2")
    public Result getEmp2(){
        return Result.success(empService.listEmp());
    }
}
