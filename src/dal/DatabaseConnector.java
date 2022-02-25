package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private static boolean initialized = false;
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION_START = "jdbc:h2:mem:StorageDb;DB_CLOSE_DELAY=-1;INIT=runscript from './create.sql';";
    private static final String DB_CONNECTION_AFTER = "jdbc:h2:mem:StorageDb;";
    private static final String DB_USER = "test";
    private static final String DB_PASSWORD = "test";

    public static Connection getConnection() {

        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if(initialized)
                dbConnection = DriverManager.getConnection(DB_CONNECTION_AFTER, DB_USER, DB_PASSWORD);
            else
            {
                initialized = true;
                dbConnection = DriverManager.getConnection(DB_CONNECTION_START, DB_USER, DB_PASSWORD);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}



