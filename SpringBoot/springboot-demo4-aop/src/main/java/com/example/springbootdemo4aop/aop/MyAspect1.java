package com.example.springbootdemo4aop.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//不同的通知类型（AOP方法上的注解）
//在TimeAspect中的@Around注解的通知（比较特殊）则是在目标方法前后执行

//如果在多个类中有相同切入点，可以通过@Order（数字）加在切面上开控制顺序，否则按字母排序
//目标方法运行前的通知方法，数字小的先执行，目标方法运行后的通知方法，数字小的后执行
@Order(1)
@Component
@Aspect
@Slf4j
public class MyAspect1 {

    //声明切入点表达式的注解，修饰符为private则只能在本类中使用
    @Pointcut("execution(* com.example.springbootdemo4aop.mvc.DeptMapper.selectAll())")
    public void pt(){}

    //idea左边有按钮查看所有关联的方法，目标方法执行前执行
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before。。。");
    }

    //目标方法执行后执行
    @After("pt()")
    public void after(){
        log.info("after。。。");
    }

    //目标方法返回后执行
    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning。。。");
    }

    //目标方法报错后执行，在这里查看部门会报错
    @AfterThrowing("execution(* com.example.springbootdemo4aop.mvc.DeptServiceImpl.selectById(..))")
    public void afterThrowing(){
        log.info("afterThrowing。。。");
    }


    @Before("@annotation(com.example.springbootdemo4aop.aop.MyLog)")
    public void annotation(){
        log.info("切入点表达式二：使用全类名注解匹配");
    }
}
