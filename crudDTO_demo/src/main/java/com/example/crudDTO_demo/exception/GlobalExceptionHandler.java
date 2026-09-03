package com.example.crudDTO_demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {


    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResorceNotFoundException(ResourceNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex){
        return ex.getMessage();
    }
    @ExceptionHandler(Exception.class)
    public String handleGenricException(Exception ex){
        return ex.getMessage();
    }
}
