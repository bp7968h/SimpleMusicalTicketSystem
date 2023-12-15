/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bpandit
 */
public class connection {
    private static final String URL = "jdbc:mysql://localhost:3306/stt_cw";
    private static final String USER = "musicAppUser";
    private static final String PASSWORD = "Ao16A0Y3CXj!";

    public static Connection getConnection() {
        try {
            // Load the JDBC driver (if necessary)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection to the database
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
