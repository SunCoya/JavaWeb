package com.example.demo1.controller;

import com.example.demo1.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//请求处理类
@RestController
public class RequestController {
    /*
        1.浏览器访问@RequestMapping注解里的地址调用此方法
        2.返回的字符串代表响应数据
    */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello world");
        return "Hello world";
    }

    /*
        1.在访问路径中也能传递请求参数
        2.通过注解可以指定请求参数的名字,也可动态设置请求参数
        3.注解@RequestParam中的的参数表示是否一定需要，默认为true，可设置为false
        4.无论是get请求还是post请求都可以对请求参数进行处理
    */
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name",required = false) String username, int age){
        return username+":"+age;
    }

    //实体参数，可以把形参写成实体类对象，不需要类的全部参数
    @RequestMapping("/pojoParam")
    public String pojoParam(User user){
        return user.toString();
    }

    //复杂实体参数，类中内部类，请求使用【实体类属性.内部类】属性发送
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        return user.toString();
    }

    //请求参数中，同key不同value参数的接收
    @RequestMapping("/arrParam")
    public String arrParam(String[] hobby){
        return Arrays.toString(hobby);
    }

    //也能用集合接收，需要加注解（因为默认封装到数组当中）
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        return hobby.toString();
    }

    //时间需要注解格式
    @RequestMapping("/timeParam")
    public String timeParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        return updateTime.toString();
    }

    //传递json参数需要使用RequestBody注解使用实体类接收,请求需要使用post
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        return user.toString();
    }

    /*  1.动态获取参数路径参数需要在请求mapping注解的路径中给变化的参数加上{}
        2.在方法中需要给参数加上@PathVariable注解
        3.请求路径中的参数有变化，如path/1...10 */
    @RequestMapping("/pathParam/{id}")
    public String pathParam(@PathVariable Integer id){
        return id.toString();
    }

    //多个路径参数
    @RequestMapping("/pathParam/{id}/{name}")
    public String pathParam2(@PathVariable Integer id,@PathVariable String name){
        return id+":"+name;
    }
}
