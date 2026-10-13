package com.example.cinelista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.cinelista")
public class CinelistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinelistaApplication.class, args);
	}

}