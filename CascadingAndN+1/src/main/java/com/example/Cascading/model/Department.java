package com.example.Cascading.model;

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

    @OneToMany(mappedBy = "department",
                cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Student> students=new ArrayList<>();
}
