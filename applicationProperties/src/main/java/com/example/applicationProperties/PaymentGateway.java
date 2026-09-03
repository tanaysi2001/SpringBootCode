package com.example.applicationProperties;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway{

    private final PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties){
        this.paymentProperties=paymentProperties;
    }

    public String getType(){
       return paymentProperties.getType();
    }

    public int getRetryCount(){
       return paymentProperties.getRetryCount();
    }

    public boolean getEnabled(){
       return paymentProperties.getIsEnabled();
    }

    public int getTimeOut(){
       return paymentProperties.getTimeOut();
    }

    

}