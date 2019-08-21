package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class InitApplication {

	public static void main(String[] args) {
		
		System.setProperty("security.user.password", "xpto123");
		
		SpringApplication.run(InitApplication.class, args);
	}
}
