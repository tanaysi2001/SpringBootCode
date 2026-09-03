package com.example.CrudDemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.example.CrudDemo.model.Student;

@Repository
public interface StudentRepository extends  JpaRepository<Student, Long> {

  List<Student> findByIsDeletedFalse();
  Optional<Student> findByIdAndIsDeletedFalse(Long id);
    //save to database
    
    

}
