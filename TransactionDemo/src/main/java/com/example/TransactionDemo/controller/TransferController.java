package com.example.TransactionDemo.controller;


import com.example.TransactionDemo.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/transfer")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }


    @PostMapping()
    public ResponseEntity<String> transferAmount(@RequestParam Long fromAcc,
                                                 @RequestParam Long toAcc,
                                                 @RequestParam BigDecimal amount) {

        transferService.transfer(fromAcc, toAcc, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Amount transfered successfully....");
    }

}

