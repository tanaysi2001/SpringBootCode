package com.example.HibernateDemo.service;

import com.example.HibernateDemo.model.Student;
import com.example.HibernateDemo.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @PersistenceContext
    private EntityManager entityManager;

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Transactional
    public Student createStudent(Student student){
       studentRepository.save(student);
       return null;
    }

    @Transactional
    public Student findStudent(Long id){

        return  studentRepository.findById(id);

    }

    @Transactional
    public Student deleteStudent(Long id){
        Student st=studentRepository.findById(id);
        studentRepository.deleteById(st);
        return null;
    }

    @Transactional
    public Student updateStudent(Student req,Long id){
       Student st= studentRepository.findById(id);
       st.setAge(req.getAge());
       st.setEmail(req.getEmail());
       st.setName(req.getName());

//       entityManager.detach(st);

       return null;
    }
}
