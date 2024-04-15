package com.example.demo.ExceptionHandler;

import com.example.demo.Entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result catchException(Exception e){
        e.printStackTrace();
        return Result.error("异常");
    }
}
