package com.insurance.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
public class InsuranceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceManagementSystemApplication.class, args);
	}

}
