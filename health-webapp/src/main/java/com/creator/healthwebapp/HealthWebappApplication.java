package com.creator.healthwebapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.creator")
@SpringBootApplication
@MapperScan("com.creator.mapper")
public class HealthWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthWebappApplication.class, args);
	}
}
