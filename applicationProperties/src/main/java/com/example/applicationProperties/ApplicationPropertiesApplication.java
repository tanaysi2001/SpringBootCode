package com.example.applicationProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class ApplicationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(ApplicationPropertiesApplication.class, args);
		
		PaymentGateway payment=context.getBean(PaymentGateway.class);
		

		// PaymentProperties payment=context.getBean(PaymentProperties.class);
		System.out.println("Timeout is : "+payment.getTimeOut());
		System.out.println("retryCount is : "+payment.getRetryCount());

		// System.out.println("Retry count is :"+payment.getRetryCount());
		
	}

}
