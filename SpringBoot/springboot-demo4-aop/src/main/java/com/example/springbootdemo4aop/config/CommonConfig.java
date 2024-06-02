package com.example.springbootdemo4aop.config;

import com.example.springbootdemo4aop.mvc.DeptController;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean//将方法返回值交给IOC管理，使其成为Bean对象，bean默认名称为方法名
    public SAXReader saxReader(DeptController deptController){
        System.out.println("在声明第三方bean可以在方法中注入其他bean："+deptController);
        return new SAXReader();
    }
}
