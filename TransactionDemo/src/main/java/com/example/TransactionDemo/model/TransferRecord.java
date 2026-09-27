package com.example.TransactionDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromAccId;
    private Long toAccId;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public TransferRecord(Long fromAccId, Long toAccId, BigDecimal amount, LocalDateTime createdAt) {
        this.fromAccId = fromAccId;
        this.toAccId = toAccId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

}
