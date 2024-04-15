package com.example.demo.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class timeAspect {

    @Pointcut("@annotation(com.example.demo.AOP.MyLog)")    //通过指定注解的方式进行AOP编程
    private void getCode(){}

    // 定义切点，这里以com.example.demo.controller包下的所有函数作为切点
    @Around("getCode()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long begin = System.currentTimeMillis();

        // 执行目标方法
        Object obj = joinPoint.proceed();

        long end = System.currentTimeMillis();
        // 执行完毕后打印耗时
        log.info("{} 执行时长 {} 毫秒", joinPoint, end - begin);

        return obj; // 返回结果
    }
}
