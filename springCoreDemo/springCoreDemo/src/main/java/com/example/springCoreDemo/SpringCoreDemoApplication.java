package com.example.springCoreDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderServives order=context.getBean(OrderServives.class);
		order.placeOrder();

		// PaymentServices payment=context.getBean(PaymentServices.class);
		// payment.payment();
		
	}

}
