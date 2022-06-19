package com.crmiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CrmivApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmivApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("06032002"));
	}

}