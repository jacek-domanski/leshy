package com.example.Leshy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Leshy"})
public class LeshyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeshyApplication.class, args);
	}

}