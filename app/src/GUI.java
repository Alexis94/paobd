import java.awt.*;
import java.sql.SQLException;

import dao.*;

import javax.swing.*;

import gui.*;

/**
 * Created by Alexis on 16/11/2016.
 */
public class GUI extends JFrame {
    public GUI() {
        try {
            DatabaseConnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.setTitle("Music Libray");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        this.setContentPane(new Home());
        this.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();  // Let the constructor do the job
            }
        });
    }
}
