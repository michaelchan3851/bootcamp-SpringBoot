package com.bootcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Configuration
// EnableAutoCongiguration
// ComponentScan (most Important)
// ComponentScan is to scan @Controller, @Service, @Repository, @Configuration
//if yes, create an object of those classes
// and put that object into SpringContext
public class DemoHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHelloworldApplication.class, args);
	}

}
