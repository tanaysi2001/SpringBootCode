package com.example.springCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.springCoreDemo.payments.PaymentServices;


@Component
public class OrderServives {

    PaymentServices payment;

    @Autowired
     OrderServives(@Qualifier("UPI") PaymentServices payment) {
        this.payment = payment;
    }

    public void placeOrder() {
        
        payment.pay();
        System.out.println("Order placed....!");
    }
}
