package com.example.SpringDataJpa.controller;


import com.example.SpringDataJpa.model.Student;
import com.example.SpringDataJpa.repository.StudentRepository;
import com.example.SpringDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Created Successfully...");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student res = studentService.fetchStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping()
    public ResponseEntity<Page<Student>> getStudents(@RequestParam int page, @RequestParam int size) {

        Sort sort = Sort.by("id").descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Student> p = studentRepository.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

}
