package gui;

import dao.DatabaseConnection;
import gui.views.HomeView;
import gui.views.LoginView;
import gui.views.SignupView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class MainLayout extends JFrame{
    public MainLayout(String windowName) {
        super(windowName);
        try {
            DatabaseConnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainLayout.this.setVisible(false);
                MainLayout.this.dispose();
                try {
                    System.out.println("Database connection closed");
                    DatabaseConnection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        HomeView homeView = new HomeView(this);

        this.setContentPane(homeView);
    }

    public void showLoginView() {
        LoginView loginView = new LoginView(this);
        this.setContentPane(loginView);
    }

    public void showSignupView() {
        SignupView signupView = new SignupView(this);
    }
}