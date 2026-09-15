package com.example.JPARelationshipDemo.service;

import com.example.JPARelationshipDemo.model.Department;
import com.example.JPARelationshipDemo.model.Student;
import com.example.JPARelationshipDemo.repository.DepartmentRepository;
import com.example.JPARelationshipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){

        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;
    }

    @Transactional
    public Student createStudent(Student student,Long id){
        Department dept= departmentRepository.findById(id);

        student.setDepartment(dept);
        dept.getStudents().add(student);
        studentRepository.save(student);
        return null;
    }

    @Transactional
    public void createStudent(Student student,String deptName){

        Department department=new Department();
        department.setDepartment(deptName);
        student.setDepartment(department);
        department.getStudents().add(student); //for bidirectional relation

        departmentRepository.save(department);
        studentRepository.save(student);
    }

}
