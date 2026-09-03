package com.example.employeeManagement.repository;

import com.example.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByIdAndIsDeletedFalse(Long id);
    List<Employee> findByIsDeletedFalse();
    List<Employee> findByNameContainingIgnoreCaseAndIsDeletedFalse(
            String name);
}
