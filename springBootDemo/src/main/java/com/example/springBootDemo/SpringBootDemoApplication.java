package com.example.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootDemoApplication.class, args);

		OrderServices order=context.getBean(OrderServices.class);
		order.placeOrder();
	}

}
