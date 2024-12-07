package com.yourcompany.sqlserverrestapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${DB_SERVER}")
    private String server;
    
    @Value("${DB_USER}")
    private String user;
    
    @Value("${DB_PASSWORD}")
    private String password;
    
    @Value("${DB_NAME}")
    private String database;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl(String.format("jdbc:sqlserver://%s;databaseName=%s", server, database));
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}