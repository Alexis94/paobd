package dao;

import java.sql.*;

/**
 * Created by Alexis on 13/11/2016.
 */

public class DatabaseConnection {
    static Connection conn;

    public static void connect() throws ClassNotFoundException {
        String driverName = "org.postgresql.Driver";
        Class.forName(driverName);

        String url = "jdbc:postgresql://localhost/pao";

        try {
            System.out.println("Connection...");
            conn = DriverManager.getConnection(url);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public static void close() throws SQLException {
        try {
            if (conn != null) conn.close();
        } catch (Exception ignored) {
        }

    }

    public static ResultSet get(String values, String table, String clauses) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT" + values + " FROM " + table + " WHERE " + clauses + ";";
        return stmt.executeQuery(sql);
    }

    public static boolean insert(String values, String table) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO " + table + " VALUES (" + values + ");";
        return stmt.executeUpdate(sql) > 0;
    }

    public static boolean delete(String table, String clauses) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM " + table + " WHERE " + clauses + ";";
        return stmt.executeUpdate(sql) > 0;
    }

    public static boolean update(String table, String values, String clauses) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate("UPDATE " + table + " SET " + values + " WHERE " + clauses + ";") > 0;
    }

}
