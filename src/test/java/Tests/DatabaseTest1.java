package Tests;
import Functions.DatabaseConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Sleeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class DatabaseTest1 {

    private DatabaseConnection dbConnection;


    @Before
    public void setUp() {
        dbConnection = new DatabaseConnection();
    }

    @Test
    public void testget() throws SQLException{
        String query2 = "select * from customers;";
        ResultSet result2 = dbConnection.getData(query2);
        System.out.println(result2);
    }

    @Test
    public void testRetrieveData() throws SQLException {
        String query = "SELECT * FROM customers WHERE customerName = 'Atelier graphique';";
        ResultSet resultSet = dbConnection.getData(query);
        assertTrue("No data found in the result set.", resultSet.next());

        // Assert and print the expected values
        do {
            // Assertions for specific column values
            assertEquals("Customer Number does not match.", 103, resultSet.getInt("customerNumber"));
            assertEquals("Customer Name does not match.", "Atelier graphique", resultSet.getString("customerName"));

            // Print data for demonstration purposes
            System.out.println("Customer Name: " + resultSet.getString("customerName"));
            System.out.println("Customer Number: " + resultSet.getInt("customerNumber"));
        } while (resultSet.next());
    }

    @Test
    public void testInsertData() throws SQLException {
        // Insert Query
        String insertQuery = "INSERT INTO customers (\n" +
                "    customerNumber, \n" +
                "    customerName, \n" +
                "    contactLastName, \n" +
                "    contactFirstName, \n" +
                "    phone, \n" +
                "    addressLine1, \n" +
                "    addressLine2, \n" +
                "    city, \n" +
                "    state, \n" +
                "    postalCode, \n" +
                "    country, \n" +
                "    salesRepEmployeeNumber, \n" +
                "    creditLimit\n" +
                ") VALUES (\n" +
                "    500,                         \n" +
                "    'Georgea Company',          \n" +
                "    'Doe',                      \n" +
                "    'John',                      \n" +
                "    '123-456-7890',              \n" +
                "    '123 Main St',              \n" +
                "    NULL,                       \n" +
                "    'New York',                 \n" +
                "    'NY',                      \n" +
                "    '10001',                   \n" +
                "    'USA',                     \n" +
                "    1370,                         \n" +
                "    50000.00                      \n" +
                ");";

        // Execute Insert Query
        int rowsInserted = dbConnection.updateData(insertQuery);
        assertTrue("No rows inserted.", rowsInserted > 0);

        // Verification Query
        String selectQuery = "SELECT * FROM customers WHERE customerNumber = 500;";
        ResultSet resultSet = dbConnection.getData(selectQuery);

        // Assert the row exists
        assertTrue("No data found for customerNumber 500.", resultSet.next());

        // Verify inserted data
        assertEquals("Customer Name does not match.", "Georgea Company", resultSet.getString("customerName"));
        assertEquals("Contact Last Name does not match.", "Doe", resultSet.getString("contactLastName"));
        assertEquals("Contact First Name does not match.", "John", resultSet.getString("contactFirstName"));
        assertEquals("Phone does not match.", "123-456-7890", resultSet.getString("phone"));
        assertEquals("Address Line 1 does not match.", "123 Main St", resultSet.getString("addressLine1"));
        assertEquals("City does not match.", "New York", resultSet.getString("city"));
        assertEquals("State does not match.", "NY", resultSet.getString("state"));
        assertEquals("Postal Code does not match.", "10001", resultSet.getString("postalCode"));
        assertEquals("Country does not match.", "USA", resultSet.getString("country"));
        assertEquals("Sales Rep Employee Number does not match.", 1370, resultSet.getInt("salesRepEmployeeNumber"));
        assertEquals("Credit Limit does not match.", 50000.00, resultSet.getDouble("creditLimit"), 0.01); // Allow small precision difference


    }
    @Test
    public void testUpdateData() throws SQLException {
        // Update Query
        String updateQuery = "UPDATE customers SET " +
                "customerName = 'Georgea Company', " +
                "contactLastName = 'Doe', " +
                "contactFirstName = 'John', " +
                "phone = '123-456-7890', " +
                "addressLine1 = '123 Main St', " +
                "addressLine2 = NULL, " +
                "city = 'New York', " +
                "state = 'NY', " +
                "postalCode = '10001', " +
                "country = 'USA', " +
                "salesRepEmployeeNumber = 1370, " +
                "creditLimit = 50000.00 " +
                "WHERE customerNumber = 119;";

        // Execute the Update Query
        int rowsUpdated = dbConnection.updateData(updateQuery);
        assertTrue("No rows updated.", rowsUpdated > 0);

        // Verify that the data was updated correctly
        String selectQuery = "SELECT * FROM customers WHERE customerNumber = 119;";
        ResultSet resultSet = dbConnection.getData(selectQuery);

        // Assert the row exists
        assertTrue("No data found for customerNumber 119.", resultSet.next());

        // Verify updated data
        assertEquals("Customer Name does not match.", "Georgea Company", resultSet.getString("customerName"));
        assertEquals("Contact Last Name does not match.", "Doe", resultSet.getString("contactLastName"));
        assertEquals("Contact First Name does not match.", "John", resultSet.getString("contactFirstName"));
        assertEquals("Phone does not match.", "123-456-7890", resultSet.getString("phone"));
        assertEquals("Address Line 1 does not match.", "123 Main St", resultSet.getString("addressLine1"));
        assertNull("Address Line 2 should be NULL.", resultSet.getString("addressLine2"));
        assertEquals("City does not match.", "New York", resultSet.getString("city"));
        assertEquals("State does not match.", "NY", resultSet.getString("state"));
        assertEquals("Postal Code does not match.", "10001", resultSet.getString("postalCode"));
        assertEquals("Country does not match.", "USA", resultSet.getString("country"));
        assertEquals("Sales Rep Employee Number does not match.", 1370, resultSet.getInt("salesRepEmployeeNumber"));
        assertEquals("Credit Limit does not match.", 50000.00, resultSet.getDouble("creditLimit"), 0.01); // Allow small precision difference
    }

//    @Test
//public void deleteinserteddata() throws InterruptedException {
//
//    String deleteQuery = "DELETE FROM customers WHERE customerNumber = 500;";
//    int rowsDeleted = dbConnection.updateData(deleteQuery);
//    assertTrue("No rows deleted.", rowsDeleted > 0);
//
//}

    @After
    public void tearDown() {
        dbConnection.closeConnection();
    }
}
