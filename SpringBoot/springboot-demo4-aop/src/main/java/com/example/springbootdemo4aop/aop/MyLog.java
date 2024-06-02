package com.example.springbootdemo4aop.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//用于切入点表达式调用的注解
@Retention(RetentionPolicy.RUNTIME)//描述注解运行时有效
@Target(ElementType.METHOD)//描述注解能作用在那些地方
public @interface MyLog {
}
