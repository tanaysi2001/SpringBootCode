package com.example.TransactionDemo.repository;

import com.example.TransactionDemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
