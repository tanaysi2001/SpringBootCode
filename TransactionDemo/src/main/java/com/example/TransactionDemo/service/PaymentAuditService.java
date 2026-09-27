package com.example.TransactionDemo.service;

import com.example.TransactionDemo.model.Order;
import com.example.TransactionDemo.model.PaymentAudit;
import com.example.TransactionDemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentRepository;

    public PaymentAuditService( PaymentAuditRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void audit(Order order){
        PaymentAudit audit = new PaymentAudit();
        audit.setOrderId(order.getId());
        audit.setAmount(order.getAmount());
        audit.setSuccess(true);
        paymentRepository.save(audit);
    }
}
