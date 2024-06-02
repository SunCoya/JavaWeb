package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.pojo.Emp;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.service.EmpService;
import com.example.springbootdemo3.utils.JwtUtils;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("用户登录：{}：{}",emp.getUsername(),emp.getPassword());
        Emp login = empService.login(emp);
        if (login!=null){
            //发送jwt，存储在浏览器的application的localstorage当中（前端职责）
            //之后前端每一次请求都在请求头token中携带jwt
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",login.getId());
            map.put("username",login.getUsername());
            map.put("password",login.getPassword());
            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        }
        return Result.error("用户名密码错误");
    }

    //在方法中也能操作请求与响应数据，cookie不能跨域，移动端也无法使用
    //令牌技术能解决上面的问题，相当于给浏览器一个身份证
    @GetMapping("/cookie")
    public Result cookie(HttpServletRequest rqs, HttpServletResponse rsp){
        return Result.success();
    }
}
