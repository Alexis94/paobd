package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    public Home(){
        this.setTitle("Bouton");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel title = new JLabel();
        title.setText("<html><h1>Music Library</h1></html>");



        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.PAGE_AXIS));
        row.add(title);
        JButton b1 = new JButton("Créer un compte");
        b1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Do Something Clicked");
            }
        });
        row.add(b1);
        row.add(new JButton("Se connecter"));

        row.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.getContentPane().add(row);
        this.setVisible(true);
    }
}