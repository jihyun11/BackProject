package com.example.backproject.service;

import com.example.backproject.dto.LetterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class LetterService {

    @Autowired
    DataSource dataSource;

    public void insertLetter (LetterDto letterDto)  {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into fan_letter (writer, email, comment) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, letterDto.getWriter());
            preparedStatement.setString(2, letterDto.getEmail());
            preparedStatement.setString(3, letterDto.getComment());
            preparedStatement.execute();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
