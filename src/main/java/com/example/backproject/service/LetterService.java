package com.example.backproject.service;

import com.example.backproject.dto.LetterDto;
import com.example.backproject.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LetterService {

    @Autowired
    DataSource dataSource;

    public void insertLetter(LetterDto letterDto) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into fan_letter (writer, email, comment) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, letterDto.getWriter());
            preparedStatement.setString(2, letterDto.getEmail());
            preparedStatement.setString(3, letterDto.getComment());
            preparedStatement.execute();

            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<LetterDto> getLetterList() {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select letter_id, writer, comment, create_time from fan_letter order by letter_id desc";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<LetterDto> list = new ArrayList<>();
            while (resultSet.next()) {
                String letterId = resultSet.getString("letter_id");
                String writer = resultSet.getString("writer");
                String comment = resultSet.getString("comment");
                String createTime = resultSet.getString("create_time");
                LetterDto letter = new LetterDto(letterId, writer, comment, createTime);

                list.add(letter);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
