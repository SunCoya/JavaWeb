package com.example.springbootdemo4aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect//声明为AOP类
@Component//将当前类交给ioc容器管理
public class TimeAspect {
    //指定功能加在哪些方法上
    @Around("execution(* com.example.springbootdemo4aop.mvc.*.*(..))")//切入点表达式

    //只有Around类型的通知才能使用ProceedingJoinPoint，其他的只能使用其父类JoinPoint
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        //运行原始方法，返回原始方法返回值
        Object result = joinPoint.proceed();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("目标方法所属类，方法名，参数："+className+" "+methodName+" "+Arrays.toString(args));

        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时{}ms",(end-begin));

        return result;
    }
    //最终在控制层注入的对象是服务层的代理对象
}

/*
切入点表达式
1.execution(修饰符 返回值 包名.类名.方法名(方法参数全类名) throws 异常)
    其中修饰符 包名.类名 抛异常可以省略
    *可以匹配返回值，包名，类名，方法名，方法中的任意类型的一个参数，也可以匹配包、类名的一部分，如*Service
    ..相当于多个*，可以匹配任意层级的包与任意个数的参数，* com..*.*(..)表示匹配该包下所有类的所有方法，进一步简写：* *(..)
    匹配多个方法可以在切入点表达式中间加||，如execution(* *(..))||execution(* *(..))，除此之外&&与！也是可以使用的
    切入点建议：尽量匹配接口而不是实现类

2.@anotation见Aspect类中的实验
*/
