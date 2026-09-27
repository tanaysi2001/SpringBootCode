package com.example.TransactionDemo.repository;

import com.example.TransactionDemo.model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord,Long> {
}
