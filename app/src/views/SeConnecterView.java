package views;

import dao.impl.UserImpl;
import dao.models.User;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Console;
import java.util.Scanner;

/**
 * Created by Alexis on 21/11/2016.
 */
public class SeConnecterView {
    public SeConnecterView(Scanner in) {
        System.out.println("-------------------------------------");
        System.out.println("| Veuillez entrer vos identifiants: |");
        System.out.print("Pseudo: ");
        String pseudo = in.nextLine();
        pseudo = in.nextLine();

        final JPasswordField jpf = new JPasswordField();
        JOptionPane jop = new JOptionPane(jpf, JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = jop.createDialog("Mot de passe:");
        dialog.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jpf.requestFocusInWindow();
                    }
                });
            }
        });
        dialog.setVisible(true);
        int result = (Integer) jop.getValue();
        dialog.dispose();
        char[] password = null;
        if (result == JOptionPane.OK_OPTION) {
            password = jpf.getPassword();
        }
        if (password != null)
            System.out.println(pseudo + " - " + new String(password));

        User user = new UserImpl().seConnecter(pseudo, new String(password));


        System.out.println("User connecté");
        MainFrameController.setUser(user);
        MainFrameController.showProfil();
    }
}
