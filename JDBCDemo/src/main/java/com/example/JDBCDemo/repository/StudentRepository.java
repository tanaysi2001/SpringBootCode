package com.example.JDBCDemo.repository;

import com.example.JDBCDemo.model.Students;

import java.sql.*;

public class StudentRepository {

    public void createUser(Students student) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Tanay@2447095";

        //making the connection
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection sucessFull");

        //creating the user and executing the queries

        String sql = """
                        INSERT INTO students(name,email,age)
                        values(?,?,?)
                        """;

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,student.getName());
        statement.setString(2, student.getEmail());
        statement.setInt(3,student.getAge());

        int rows=statement.executeUpdate();

        if(rows==1) System.out.println("Successfull");
        else System.out.println("Execution failed");


        connection.close();
    }

    //get the user
    public void getUserById() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Tanay@2447095";

        //making the connection
        Connection connection = DriverManager.getConnection(url, username, password);
//        System.out.println("Connection sucessFull");

        //creating the user and executing the queries

        Statement statement = connection.createStatement();
        String sql = "SELECT name,email,age FROM STUDENTS";

        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Students student = mapToRow(resultSet);
            System.out.println(student);
//            System.out.println(student.getName());
//            System.out.println(student.getAge());
//            System.out.println(student.getEmail());

        }

        connection.close();
    }

    //execute
    public void genralQuery() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Tanay@2447095";

        //making the connection
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "SELECT name,email,age FROM STUDENTS";

        boolean result = statement.execute(sql);
        if(result){
            ResultSet resultSet=statement.getResultSet();

            while(resultSet.next()){
                Students student=mapToRow(resultSet);
                System.out.println(student);

            }
        }
        else{
            int affectedRows=statement.getUpdateCount();
            System.out.println(affectedRows);
        }
        System.out.println(result);
        connection.close();
    }


private Students mapToRow(ResultSet resultSet) throws SQLException {
    Students response = new Students();
    response.setAge(resultSet.getInt(3));
    response.setName(resultSet.getString(1));
    response.setEmail(resultSet.getString(2));
    return response;
}

}
