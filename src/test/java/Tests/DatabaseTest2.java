package Tests;

import Functions.DatabaseConnection2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DatabaseTest2 {
    private DatabaseConnection2 dbConnection;

    @Before
    public void setUp() {
        dbConnection = new DatabaseConnection2();
    }

    @Test
    public void testGetData() {
        String query = "SELECT * FROM customers WHERE customerName = 'Atelier graphique'";
        String expectedValue = "Atelier graphique"; // Replace with the expected result

        // Call getData and verify the result
        String actualValue = dbConnection.getData(query, "customerName");
        System.out.println(actualValue);
        assertEquals("Data retrieved from database does not match expected value.", expectedValue, actualValue);
    }

    @After
    public void tearDown() {
        dbConnection.closeConnection();
    }
}

