package com.example.backproject.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        // 스프링부트에서 가장 기본이 되는 DB Connection pool : Hikari DB Pool
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        hikariDataSource.setJdbcUrl("jdbc:mysql://52.79.32.80:3306/lol");
        hikariDataSource.setUsername("gumayusi");
        hikariDataSource.setPassword("test123");
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return hikariDataSource;
    }
}
