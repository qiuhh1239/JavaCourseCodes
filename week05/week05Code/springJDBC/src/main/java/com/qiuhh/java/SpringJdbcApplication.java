package com.qiuhh.java;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringJdbcApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		
		Arrays.sort(beanNames);
		for(String beanName :beanNames) {
			System.out.println("Spring Boot 2.5 自动化配置："+beanName);
			
		}
	}

}
