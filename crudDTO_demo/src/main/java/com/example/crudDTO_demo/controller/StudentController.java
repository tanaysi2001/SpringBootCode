package com.example.crudDTO_demo.controller;

import java.util.ArrayList;

import com.example.crudDTO_demo.dto.StudentRequestDTO;
import com.example.crudDTO_demo.dto.StudentResponseDTO;
import com.example.crudDTO_demo.dto.UpdateStudentReqDTO;
import com.example.crudDTO_demo.dto.UpdateStudentResDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudDTO_demo.model.Student;
import com.example.crudDTO_demo.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO studentDto) {
        StudentResponseDTO studentResp= studentService.create(studentDto);
        return studentResp;
    }

    //read the data of one student
    @GetMapping("/get/{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id) {

        return studentService.getStudent(id);
    }

    //read the data of all students
    @GetMapping("/get")
    public ArrayList<StudentResponseDTO> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public UpdateStudentResDTO updateStudent(@RequestBody UpdateStudentReqDTO studentReq, @PathVariable Long id) {

        return studentService.updateStudent(studentReq, id);
    }

    @DeleteMapping("/delete/{id}")
    public StudentResponseDTO deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/softDelete/{id}")
    public StudentResponseDTO softDelete(@PathVariable Long id) {
        return studentService.softDelete(id);
    }
}