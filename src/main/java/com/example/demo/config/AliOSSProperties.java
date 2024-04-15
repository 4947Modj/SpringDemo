package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data  // 自动生成getter和setter方法
@Component  // 可以将该类加入IOC容器中
@ConfigurationProperties(prefix = "aliyun.oss") // 指定配置文件中的前缀
public class AliOSSProperties{
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    // getter and setter
}
