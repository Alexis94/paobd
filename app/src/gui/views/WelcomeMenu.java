package gui.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexis on 21/11/2016.
 */
public class WelcomeMenu extends JPanel{

    private JPanel MainPanel;
    private JButton seConnecterButton;
    private JButton creerCompte;

    public WelcomeMenu() {
        seConnecterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        creerCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("WelcomeMenu");
        frame.setContentPane(new WelcomeMenu().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
}
