package com.example.HibernateDemo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            unique = true,
            nullable = false
    )
    private String name;
    private String email;
    private String age;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Convert(converter = BooleanToStringConverter.class)
    private boolean isMoniter;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNo",
                    column = @Column(name = "stud_house_no")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "stud_street")),
            @AttributeOverride(name = "city",
                    column = @Column(name = "stud_city")),
            @AttributeOverride(name = "state",
                    column = @Column(name = "stud_state")),
            @AttributeOverride(name = "pincode",
                    column = @Column(name = "stud_pincode")),
    })
    private Address address;

    @ElementCollection
    @CollectionTable(name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id"))
    private Set<String> skills;

    public Student() {
    }

    ;

    public Student(String name, String email, String age, StudentStatus status, boolean isMoniter, Address address, Set<String> skills) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.status = status;
        this.isMoniter = isMoniter;
        this.address = address;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public boolean isMoniter() {
        return isMoniter;
    }

    public void setMoniter(boolean moniter) {
        isMoniter = moniter;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}


