package com.example.backproject.service;

import com.example.backproject.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class SignService {
    @Autowired
    private DataSource dataSource;
    public void signup(MemberDto md) {
        try {
            Connection connection = dataSource.getConnection();
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

    public MemberDto signin(MemberDto md) {
        MemberDto memberDto = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select username, password, phone, email from member where username = ? and password = ?");
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
        }
        return memberDto;


    }

}



