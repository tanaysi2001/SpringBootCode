package com.example.JPARelationshipDemo.repository;


import com.example.JPARelationshipDemo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user){
        entityManager.persist(user);
    }
}
