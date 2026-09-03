package com.example.springCoreDemo.payments;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("UPI")
public class UpiPayment implements PaymentServices {
    
    @Override
    public void pay(){
        System.out.println("Payment via UPI....!");
    }
}
