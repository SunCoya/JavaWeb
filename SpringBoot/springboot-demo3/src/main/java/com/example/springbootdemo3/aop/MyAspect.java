package com.example.springbootdemo3.aop;

import com.alibaba.fastjson2.JSONObject;
import com.example.springbootdemo3.mapper.OperateLogMapper;
import com.example.springbootdemo3.pojo.OperateLog;
import com.example.springbootdemo3.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class MyAspect {


    @Autowired
    private HttpServletRequest req;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.example.springbootdemo3.aop.Log)")
    public Object recordTLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object result =  joinPoint.proceed();
        Long end = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();
        //在jwt中获取信息，自动注入请求对象
        Claims claims = JwtUtils.parseJWT(req.getHeader("token"));
        operateLog.setOperateUser(claims.get("id", Integer.class));
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(JSONObject.toJSONString(result));
        operateLog.setCostTime(end-begin);
        operateLogMapper.insert(operateLog);

        return result;
    }

}
