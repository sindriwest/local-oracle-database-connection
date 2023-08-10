package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDatabaseConnection {

    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/ORCLPDB1";
        String username = "system";
        String password = "pass";

        System.out.println("TEST RUN START");

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Process the result set
            while (resultSet.next()) {
                String data = resultSet.getString("column_name");
                System.out.println("Data: " + data);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("TEST RUN END");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}