package com.example.backproject;

import com.example.backproject.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public static MemberDto signin(MemberDto md) {
        MemberDto memberDto = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://52.79.32.80:3306/lol", "gumayusi", "test123");
            PreparedStatement preparedStatement = connection.prepareStatement("select username, password, phone, email from member where username=? and password=?");
            preparedStatement.setString(1, md.getUsername());
            preparedStatement.setString(2, md.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                memberDto = new MemberDto(username, password, phone, email);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } return memberDto;
    }

}
