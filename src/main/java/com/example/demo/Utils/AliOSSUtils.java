package com.example.demo.Utils;

import com.example.demo.config.AliOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //将该类注入到Spring容器中
public class AliOSSUtils {

    @Autowired //依赖注入
    private  AliOSSProperties aliOSSProperties;
}
