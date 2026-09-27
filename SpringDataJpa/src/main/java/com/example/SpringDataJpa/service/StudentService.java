package com.example.SpringDataJpa.service;

import com.example.SpringDataJpa.model.Student;
import com.example.SpringDataJpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student fetchStudent(Long id) {
        return studentRepository.findById(id);
    }
}
