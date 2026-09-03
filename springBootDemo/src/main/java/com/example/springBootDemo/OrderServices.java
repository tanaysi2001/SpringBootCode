package com.example.springBootDemo;

import org.springframework.stereotype.Component;

@Component
public class OrderServices {
     PaymentService payment;
    

   
    OrderServices(PaymentService payment){
        this.payment=payment;
    }

    public void placeOrder(){

        payment.pay();

        System.out.println(" Order Placed....!");
    }
}
