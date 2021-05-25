package databaseClasses;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Central class to connect to the database
public class Database {

    public static final String URL = "jdbc:derby://localhost:1527/TalabatClone";
    public static final String USER = "Talabat";
    public static final String PASS = "Talabat1234";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}
