package com.example.mvcDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.example.mvcDemo")
@EnableWebMvc
public class WebConfig {
    
}
