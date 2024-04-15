package com.example.demo;

import com.example.demo.Controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	DeptController deptController;

	@Test
	void contextLoads() {
		//根据bean的名称获取bean对象
		DeptController bean1 =(DeptController) applicationContext.getBean("deptController");
		System.out.println(bean1);
		DeptController bean2 = applicationContext.getBean(DeptController.class);
		System.out.println(bean2);
		DeptController bean3 = applicationContext.getBean("deptController",DeptController.class);
		System.out.println(bean3);
	}
}
