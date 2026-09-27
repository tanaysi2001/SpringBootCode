package com.example.TransactionDemo.controller;

import com.example.TransactionDemo.model.Account;
import com.example.TransactionDemo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/account")
public class AccountController {
    private AccountService accountService;

    private AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully....");

    }
}
