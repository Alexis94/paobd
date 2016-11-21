package gui.views;


import gui.MainLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexis on 21/11/2016.
 */
public class HomeView extends JPanel implements ActionListener {
    MainLayout parentFrame;
    JButton seConnecter;
    JButton creerCompte;
    public HomeView(MainLayout parent) {
        super(new GridLayout(1, 2));
        this.parentFrame = parent;

        seConnecter = new JButton("Se connecter");
        creerCompte = new JButton("Créer compte");

        seConnecter.setActionCommand("seConnecter");
        creerCompte.setActionCommand("creerCompte");

        seConnecter.addActionListener(this);
        creerCompte.addActionListener(this);

        this.add(seConnecter);
        this.add(creerCompte);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if (e.getSource() == seConnecter) {
            this.parentFrame.showLoginView();
        } else if (e.getSource() == creerCompte) {
            this.parentFrame.showSignupView();
        }
    }
}
