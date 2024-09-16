package ua.example.config;

import java.sql.*;

public class Database {
    private static Database instance;
    private static final String URL = "jdbc:postgresql://localhost:5442/database-dev-6";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}