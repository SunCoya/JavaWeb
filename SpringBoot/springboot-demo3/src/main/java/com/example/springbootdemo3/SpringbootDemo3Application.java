package com.example.springbootdemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//想要使用WebFilter，需要加上这个注解，这里不使用
//@ServletComponentScan
@SpringBootApplication
public class SpringbootDemo3Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo3Application.class, args);
    }
}
