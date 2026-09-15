package com.example.JPARelationshipDemo.controller;

import com.example.JPARelationshipDemo.model.Department;
import com.example.JPARelationshipDemo.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
//        System.out.println("DEpartment received in controller layer " + department);
        Department dept = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department created...");
    }

    @PostMapping("/createDepartment/{studName}")
    public ResponseEntity<String> createDepartment(@RequestBody Department department, @PathVariable String studName) {
        departmentService.createDepartment(department, studName);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department  and student created...");
    }
}



