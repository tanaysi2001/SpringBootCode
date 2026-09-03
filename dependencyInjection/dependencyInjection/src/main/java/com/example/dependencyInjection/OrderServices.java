package com.example.dependencyInjection;
public class OrderServices {

 EmailServices email;

    public OrderServices(EmailServices email) {
        this.email=email;
    }
    public void placeOrder(){

        // EmailServices email=new EmailServices();
        System.out.println("Order placed...!");
        email.sendEmail();
    }
    
}
