package dao;

import java.sql.*;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String query) throws SQLException {
        stmt = conn.createStatement();
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
}
