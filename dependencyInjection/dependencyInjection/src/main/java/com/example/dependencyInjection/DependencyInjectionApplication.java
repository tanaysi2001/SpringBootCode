package com.example.dependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
		
		EmailServices email=new EmailServices();
		// MessageServices msg=new MessageServices();
		OrderServices order=new OrderServices(email);
		order.placeOrder();
	}

}
