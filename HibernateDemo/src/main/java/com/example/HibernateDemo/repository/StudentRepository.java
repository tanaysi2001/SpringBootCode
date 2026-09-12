package com.example.HibernateDemo.repository;

import com.example.HibernateDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //create student
    public void save(Student student) {
        entityManager.persist(student);
    }

    //read student
    public Student findById(Long id) {

        return entityManager.find(Student.class, id);
    }

    //delete the student
    public void deleteById(Student student) {

        entityManager.remove(student);
    }
}
