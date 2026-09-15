package com.example.JPARelationshipDemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String department;

    @OneToMany(mappedBy = "department")
    private List<Student> students=new ArrayList<>();
}
