package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {
    
    @GetMapping("/hello")
    public String hello(){
        return "<h1>Hello Buddy....!</h1>";
    }

    @GetMapping("/bye")
    public String bye() {
        return "<h6>Bye bro</h6>";
    }
    
    
}
