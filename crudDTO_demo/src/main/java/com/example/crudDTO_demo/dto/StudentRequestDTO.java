package com.example.crudDTO_demo.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDTO {
    @NotBlank(message="Name cannot be blank")
    @NotNull(message="Name Cannot be null")
    private String name;

    @NotBlank(message="Age cannot be blank")
    @NotNull(message="Age Cannot be null")
    @Positive(message="Age cannot be negative")
    @Min(value=18)
    private int age;

    @NotBlank(message="email cannot be blank")
    @NotNull(message="email Cannot be null")
    @Email(message="email a Valid email")
    private String email;

    @NotBlank(message="rollNo cannot be blank")
    @NotNull(message="rollNo Cannot be null")
    @Positive(message="rollNo cannot be negative")
    private int rollNo;

    @NotBlank(message="Name cannot be blank")
    @NotNull(message="Name Cannot be null")
    private String sub;

    @NotBlank(message="id cannot be blank")
    @NotNull(message="id Cannot be null")
    private Long id;

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

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
