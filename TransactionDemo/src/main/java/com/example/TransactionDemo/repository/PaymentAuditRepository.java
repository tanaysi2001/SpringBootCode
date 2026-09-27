package com.example.TransactionDemo.repository;

import com.example.TransactionDemo.model.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit,Long> {
}
