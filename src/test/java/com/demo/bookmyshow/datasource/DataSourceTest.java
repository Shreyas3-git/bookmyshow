package com.demo.bookmyshow.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DataSourceTest implements CommandLineRunner {
    @Autowired
    @Qualifier("db2DataSource")
    private DataSource db2DataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = db2DataSource.getConnection()) {
            System.out.println("Successfully connected to secondary database (oauth_db)");
        } catch (SQLException e) {
            System.err.println("Failed to connect to secondary database: " + e.getMessage());
            throw e; // Re-throw to ensure the app fails if connection is broken
        }
    }
}