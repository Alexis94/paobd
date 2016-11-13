/**
 * Created by Alexis on 13/11/2016.
 */

import dao.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("SELECT");
            DatabaseConnection.select("SELECT * FROM TITRE;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
