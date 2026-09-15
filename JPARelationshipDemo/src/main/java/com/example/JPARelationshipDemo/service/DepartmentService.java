package com.example.JPARelationshipDemo.service;


import com.example.JPARelationshipDemo.model.Department;
import com.example.JPARelationshipDemo.model.Student;
import com.example.JPARelationshipDemo.repository.DepartmentRepository;
import com.example.JPARelationshipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository  ) {
        this.departmentRepository = departmentRepository;
        this.studentRepository=studentRepository;
    }

    @Transactional
    public Department createDepartment(Department department) {
        departmentRepository.save(department);
        return null;

    }

    @Transactional
    public void createDepartment(Department department, String studName) {
        Student stud = new Student();
        stud.setName(studName);
        stud.setDepartment(department);
        department.getStudents().add(stud);

        studentRepository.save(stud);
        departmentRepository.save(department);
    }
}
