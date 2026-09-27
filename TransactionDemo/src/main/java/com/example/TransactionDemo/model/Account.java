package com.example.TransactionDemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal balance;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public void debitAmount(BigDecimal amount) {

        if(amount==null || amount.signum()<=0){
            throw new IllegalArgumentException(" Amount should be positive....");
        }

        if(amount.compareTo(balance)>0){
            throw new RuntimeException("Insuuficient balance...");
        }

        balance=balance.subtract(amount);

    }

    public void creditAmount(BigDecimal amount) {
        if(amount==null || amount.signum()<=0){
            throw new IllegalArgumentException(" Amount should be positive....");
        }
        balance = balance.add(amount);
    }
}
