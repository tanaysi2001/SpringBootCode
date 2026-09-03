package com.example.employeeManagement.exception;

public class InvalidSearchException  extends RuntimeException{
    public InvalidSearchException(String message){
        super(message);
    }
}
