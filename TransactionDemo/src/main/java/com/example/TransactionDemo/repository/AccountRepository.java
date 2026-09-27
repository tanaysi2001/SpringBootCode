package com.example.TransactionDemo.repository;

import com.example.TransactionDemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
