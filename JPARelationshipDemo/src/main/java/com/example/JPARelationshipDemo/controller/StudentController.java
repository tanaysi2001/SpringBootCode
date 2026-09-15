package com.example.JPARelationshipDemo.controller;


import com.example.JPARelationshipDemo.model.Student;
import com.example.JPARelationshipDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @PostMapping("/create-id/{id}")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, @PathVariable Long id) {

        Student st = studentService.createStudent(student, id);
        return ResponseEntity.status(HttpStatus.OK).body(st);
    }

    @PostMapping("/create-name/{deptName}")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable String deptName) {

        studentService.createStudent(student, deptName);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created...");
    }
}
