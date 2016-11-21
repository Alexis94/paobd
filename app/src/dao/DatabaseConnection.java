package dao;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Alexis on 13/11/2016.
 */

public class DatabaseConnection {
    static Connection conn;
    static ResultSet rs;
    static Statement stmt;

    public static void connect() throws ClassNotFoundException {
        String driverName = "org.postgresql.Driver";
        Class.forName(driverName);

        String url = "jdbc:postgresql://localhost/pao";

        try {
            System.out.println("Connection...");
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        //
        /*while (rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            int duree = rs.getInt("duree");
            String nomArtiste = rs.getString("nomartiste");
            String nomAlbum = rs.getString("nomalbum");
            String genre = rs.getString("genre");
            System.out.println(id + "\t|" + nom +
                    "\t|" + duree + "\t|" + nomArtiste +
                    "\t|" + nomAlbum + "\t|" + genre);
        }*/
        return rs;
    }

    public static void close() throws SQLException {
        try {
            if (rs != null) rs.close();
        } catch (Exception ignored) {}
        try {
            if (stmt != null) stmt.close();
        } catch (Exception ignored) {}
        try {
            if (conn != null) conn.close();
        } catch (Exception ignored) {}

    }

    public static ResultSet get(String values, String clauses, String table) throws SQLException {
        return stmt.executeQuery("SELECT" + values + " FROM " + table + " WHERE " + clauses);
    }

    public static boolean insert(String values, String table) throws  SQLException {
        return stmt.executeUpdate("INSERT INTO " + table + " VALUES (" + values + ")") > 0;
    }

    public static boolean delete(String table, String clauses) throws SQLException {
        return stmt.executeUpdate("DELETE FROM " + table + " WHERE " + clauses) > 0;
    }

    public static boolean update(String table, String values, String clauses) throws SQLException {
        return stmt.executeUpdate("UPDATE " + table + " SET " + values + " WHERE " + clauses) > 0;
    }

}
