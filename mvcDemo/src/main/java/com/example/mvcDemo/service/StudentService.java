package com.example.mvcDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mvcDemo.model.Student;
import com.example.mvcDemo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    // Dependency injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student studentReq) {
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}