package com.example.springbootdemo3.exception;
import com.example.springbootdemo3.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//指定要捕获的异常：所有异常
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
