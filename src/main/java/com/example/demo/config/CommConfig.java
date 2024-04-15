package com.example.demo.config;

import com.alibaba.fastjson2.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CommConfig {
    //在这个类中集中定义第三方的bean对象

    @Bean//声明第三方的bean对象
    public JSON getJson(){
        return new JSON() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
