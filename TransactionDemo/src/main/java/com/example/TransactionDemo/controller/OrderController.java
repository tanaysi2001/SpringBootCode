package com.example.TransactionDemo.controller;


import com.example.TransactionDemo.model.Order;
import com.example.TransactionDemo.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private OrderService orderService;
    public OrderController( OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order Created...");
    }

}
