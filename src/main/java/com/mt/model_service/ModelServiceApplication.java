package com.mt.model_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ModelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelServiceApplication.class, args);
	}
	@Bean
	ObjectMapper objectMapper () {
		return new ObjectMapper();
	}
}
