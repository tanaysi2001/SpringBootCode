package com.example.JPARelationshipDemo.controller;


import com.example.JPARelationshipDemo.model.User;
import com.example.JPARelationshipDemo.service.UserService;
import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){

        this.userService=userService;
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody User user, @RequestParam String bio){
        userService.createUser(user,bio);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created...");
    }

}

