package com.felipe.fabrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class FabricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricaApplication.class, args);
	}

}