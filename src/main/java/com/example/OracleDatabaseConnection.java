package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDatabaseConnection {

    public static void main(String[] args) {
        // Database connection parameters with the Oracle container internal IP and port
        String jdbcUrl = "jdbc:oracle:thin:@172.24.96.1:1521/ORCLPDB1";
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
                int id = resultSet.getRow();
                String employeeName = resultSet.getString("employee_name");
                String city = resultSet.getString("city");

                System.out.println("Employee ID: " + id + " - Employee name: " + employeeName + " - City: " + city);
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
