package com.example.backproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.79.32.80:3306/lol", "gumayusi", "test123");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member(username, password, phone, email) values(?, ?, ?, ?)");
        preparedStatement.setString(1, "지현");
        preparedStatement.setString(2, "1234");
        preparedStatement.setString(3, "01083520127");
        preparedStatement.setString(4, "372491@naver.com");
        preparedStatement.execute();



    }

}
