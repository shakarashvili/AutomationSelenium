package Functions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/classicmodels"; // Replace with your DB
    private String user = "root"; // Replace with your username
    private String password = "123123"; // Replace with your password

    // Initialize connection to the database
    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Fetch data from a table
    public ResultSet getData(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    // Insert, Update, or Delete data
    public int updateData(String query) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
    }
}
