package com.example.springCoreDemo.payments;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("credit")
public class CreditPayment implements PaymentServices {
    
    @Override
    public void pay(){
        System.out.println("Payment done via credit card....!");
    }
}
