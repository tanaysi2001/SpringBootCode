package com.example.Cascading.repository;


import com.example.Cascading.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Student save(Student student) {
        entityManager.persist(student);
        return null;
    }
}
