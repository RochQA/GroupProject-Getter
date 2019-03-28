package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GetterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetterApplication.class, args);
	}

}
