package com.example.backproject.service;

import com.example.backproject.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignService {
    public static void signup(MemberDto md) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://52.79.32.80:3306/lol", "gumayusi", "test123");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member(username, password, phone, email) values(?, ?, ?, ?)");
            preparedStatement.setString(1, md.getUsername());
            preparedStatement.setString(2, md.getPassword());
            preparedStatement.setString(3, md.getPhone());
            preparedStatement.setString(4, md.getEmail());
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    }

