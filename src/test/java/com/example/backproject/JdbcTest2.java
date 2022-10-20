package com.example.backproject;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest2 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.79.32.80:3306/lol", "gumayusi", "test123");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member(username, password, phone, email) values(?, ?, ?, ?)");
        preparedStatement.setString(1, "jihyun");
        preparedStatement.setString(2, "jihyun11");
        preparedStatement.setString(3, "01083520127");
        preparedStatement.setString(4, "jihyun@naver.com");
        PreparedStatement.execute();
    } //service 부분 복습
}
