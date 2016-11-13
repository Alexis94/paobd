package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alexis on 13/11/2016.
 */
public class DatabaseConnection {
    public static void connect() throws ClassNotFoundException {
        String driverName = "org.postgresql.Driver";
        Class.forName(driverName);

        String url = "jdbc:postgresql://localhost/pao";

        try {
            System.out.println("Connection...");
            Connection conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
