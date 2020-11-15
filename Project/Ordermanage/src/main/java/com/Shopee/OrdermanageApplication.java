package com.Shopee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//RestController
@SpringBootApplication
@EnableAutoConfiguration
public class OrdermanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermanageApplication.class, args);
	}

	//@GetMapping("/")
	//public String hello() {
	//	return "Hello Docker";
	//}
}
