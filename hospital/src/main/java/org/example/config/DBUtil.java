package org.example.config;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL      = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sherry.123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
