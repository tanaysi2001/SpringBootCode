package com.example.TransactionDemo.service;

import com.example.TransactionDemo.model.Account;
import com.example.TransactionDemo.repository.AccountRepository;
import com.example.TransactionDemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public AccountService(AccountRepository accountRepository
            , TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void createAccount(Account account){
        accountRepository.save(account);
    }


}
