package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

public class DatabaseTest3 {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    @BeforeClass
    public static void setup() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123123");
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    @Test
    public void test_storedProcedureExists() throws SQLException {
        stmt = con.createStatement();
        rs = stmt.executeQuery("SHOW PROCEDURE STATUS WHERE Name='SelectAllCustomers'");
        Assert.assertTrue("Stored procedure 'SelectAllCustomers' should exist", rs.next());
        Assert.assertEquals("SelectAllCustomers", rs.getString("Name"));
    }
    @Test
    public void test_SelectAllCustomers() throws SQLException {

    }
}
