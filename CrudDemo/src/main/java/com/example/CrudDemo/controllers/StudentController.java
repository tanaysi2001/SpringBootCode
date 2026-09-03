package com.example.CrudDemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudDemo.model.Student;
import com.example.CrudDemo.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    
    @PostMapping("/create") 
    public Student createStudent(@RequestBody Student student){

       Student createdStudent= studentService.create(student);
       
       return createdStudent;
    }

    //read the data of one student
    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable Long id){
       Student studentResponse= studentService.getStudent(id);
       return studentResponse;
    }

    //read the data of all students
    @GetMapping("/get")
    public List<Student> getAllStudents(){
      List<Student> studentResponse= studentService.getAllStudents();
      return studentResponse;
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id){

        Student updatedStudent=studentService.updateStudent(student,id);
        return updatedStudent;
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/softDelete/{id}")
    public Student softDelete(@PathVariable Long id){
        return studentService.softDelete(id);
    }
}
