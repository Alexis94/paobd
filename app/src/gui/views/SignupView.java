package gui.views;

import gui.MainLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexis on 21/11/2016.
 */
public class SignupView extends JPanel implements ActionListener {
    JTextField pseudo;
    JPasswordField password;
    JTextField nom;
    JTextField prenom;
    JTextField age;
    JButton signupBtn;
    MainLayout parent;
    public SignupView(MainLayout parent) {
        super();
        this.setLayout(new GridBagLayout());

        this.parent = parent;
        /*Box boxPseudo = Box.createHorizontalBox();
        JLabel pseudoLabel = new JLabel("Pseudo");
        this.pseudo = new JTextField();
        this.pseudo.setPreferredSize(new Dimension(100, 30));
        boxPseudo.add(pseudoLabel);
        boxPseudo.add(pseudo);


        Box boxPassword = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password");
        this.password = new JPasswordField();
        this.password.setPreferredSize(new Dimension(100, 30));
        boxPassword.add(passwordLabel);
        boxPassword.add(password);

        Box boxNom = Box.createHorizontalBox();
        JLabel nomLabel = new JLabel("Nom");
        this.nom = new JTextField();
        this.nom.setPreferredSize(new Dimension(100, 30));
        boxNom.add(nomLabel);
        boxNom.add(nom);

        Box boxPrenom = Box.createHorizontalBox();
        JLabel prenomLabel = new JLabel("Prénom");
        this.prenom = new JTextField("", 10);
        boxPrenom.add(prenomLabel);
        boxPrenom.add(prenom);

        Box boxAge = Box.createHorizontalBox();
        JLabel ageLabel = new JLabel("Age");
        this.age = new JTextField();
        this.age.setPreferredSize(new Dimension(100, 30));
        boxAge.add(ageLabel);
        boxAge.add(age);

        this.signupBtn = new JButton("Create Account");

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(boxPseudo);
        verticalBox.add(boxPassword);
        verticalBox.add(boxNom);
        verticalBox.add(boxPrenom);
        verticalBox.add(boxAge);
        verticalBox.add(this.signupBtn);

        this.add(verticalBox);

        parent.setContentPane(this);
        this.setVisible(true);*/


        signupBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupBtn){
        }
    }
}
