package com.example.TransactionDemo.service;

import com.example.TransactionDemo.model.Account;
import com.example.TransactionDemo.model.TransferRecord;
import com.example.TransactionDemo.repository.AccountRepository;
import com.example.TransactionDemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository
    ) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }


    @Transactional
    public void transfer(Long fromAccId, Long toAccId, BigDecimal amount) {
        Account fromAcc = accountRepository.findById(fromAccId).orElseThrow(() -> new RuntimeException(""));
        Account toAcc = accountRepository.findById(toAccId).orElseThrow(() -> new RuntimeException(""));
        TransferRecord record = new TransferRecord();

        fromAcc.debitAmount(amount);
        toAcc.creditAmount(amount);

        record.setAmount(amount);
        record.setFromAccId(fromAccId);
        record.setToAccId(toAccId);
        record.setCreatedAt(LocalDateTime.now());
        transferRepository.save(record);
        throw new RuntimeException("Some error Occured");
    }
}
