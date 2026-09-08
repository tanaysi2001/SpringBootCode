package com.example.JDBCDemo;

import com.example.JDBCDemo.model.Students;
import com.example.JDBCDemo.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcDemoApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(JdbcDemoApplication.class, args);
        StudentRepository repository = new StudentRepository();
		repository.createUser(new Students("Sushmu","sushmu@gmail.com",25));
//		repository.getUserById();
//        repository.genralQuery();


    }

}
