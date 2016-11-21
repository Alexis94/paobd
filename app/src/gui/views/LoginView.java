package gui.views;

import gui.MainLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexis on 21/11/2016.
 */
public class LoginView extends JPanel {
    JTextField pseudo;
    JPasswordField password;
    JLabel pseudoLabel;
    JLabel passwordLabel;
    JButton loginBtn;

    public LoginView(MainLayout parent) {
        super(new BorderLayout());

        JPanel pseudoPane = new JPanel(new FlowLayout());
        pseudoLabel = new JLabel("Pseudo");
        pseudo = new JTextField();
        pseudo.setPreferredSize(new Dimension(100, 30));
        pseudoPane.add(pseudoLabel);
        pseudoPane.add(pseudo);

        JPanel passwordPane = new JPanel(new FlowLayout());
        passwordLabel = new JLabel("Mot de passe");
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(100, 30));
        passwordPane.add(passwordLabel);
        passwordPane.add(password);

        loginBtn = new JButton("Login");

        this.add(pseudoPane, BorderLayout.NORTH);
        this.add(passwordPane, BorderLayout.CENTER);
        this.add(loginBtn, BorderLayout.SOUTH);
        parent.setContentPane(this);

        this.setVisible(true);
    }
}
