package com.creator.healthwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.creator")
@SpringBootApplication
public class HealthWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthWebappApplication.class, args);
	}
}
