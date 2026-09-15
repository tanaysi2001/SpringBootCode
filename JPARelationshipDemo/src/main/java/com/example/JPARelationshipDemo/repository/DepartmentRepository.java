package com.example.JPARelationshipDemo.repository;


import com.example.JPARelationshipDemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Department findById(Long id){
        return entityManager.find(Department.class,id);
    }
    public void save(Department department) {
        entityManager.persist(department);
    }

    public void save(String department) {
        entityManager.persist(department);
    }
}
