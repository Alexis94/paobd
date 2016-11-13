/**
 * Created by Alexis on 13/11/2016.
 */

import dao.impl.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        try {
            DatabaseConnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
