package com.finhive.ISOreader.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.finhive.ISOreader.Repository")
public class IsOreaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsOreaderApplication.class, args);
	}

}
