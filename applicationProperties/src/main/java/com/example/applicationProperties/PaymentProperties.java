package com.example.applicationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="payment-property")
@Component
public class PaymentProperties {

    private String type;
    private int retryCount;
    private boolean enabled;
    private int timeOut;

    public void setType(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }

    public void setRetryCount(int retryCount){
        this.retryCount=retryCount;
    }

    public int getRetryCount(){
        return retryCount;
    }

    public void setIsEnabled(boolean enabled){
        this.enabled=enabled;
    }

    public boolean getIsEnabled(){
        return enabled;
    }
    public void setTimeOut(int timeOut){
        this.timeOut=timeOut;
    }

    public int getTimeOut(){
        return timeOut;
    }    
}
