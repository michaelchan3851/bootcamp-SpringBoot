package com.bootcamp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.demo.service.StockService;

@SpringBootApplication
public class StockApplication {


	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}
