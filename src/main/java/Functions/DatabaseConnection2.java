package Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection2 {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/classicmodels"; // Replace with your DB
    private String user = "root"; // Replace with your username
    private String password = "123123"; // Replace with your password

    // Initialize connection to the database
    public DatabaseConnection2() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get data from the database
    public String getData(String query, String columnName) {
        String data = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieve the first row's data from the specified column
            if (resultSet.next()) {
                data = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    // Close the connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}