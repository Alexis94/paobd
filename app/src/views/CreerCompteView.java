package views;

import dao.impl.UserImpl;
import dao.models.User;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner;

/**
 * Created by Alexis on 21/11/2016.
 */
public class CreerCompteView {
    CreerCompteView(Scanner in) {
        User user = new User();

        System.out.println("-------------------------------------");
        System.out.println("| Entrez les informations suivantes: |");
        System.out.print("Pseudo: ");
        user.setPseudo(in.nextLine());
        user.setPseudo(in.nextLine());

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
        if (password != null) {
            System.out.println("Mot de passe: " + new String(new char[password.length]).replace("\0", "*"));
            user.setPassword(new String(password));
        }

        System.out.print("Prénom: ");
        user.setPrenom(in.nextLine());

        System.out.print("Nom: ");
        user.setNom(in.nextLine());

        System.out.print("Age: ");
        user.setAge(in.nextInt());

        if (new UserImpl().ajouterUser(user)) {
            System.out.println("Votre compte a été créé avec succès ! Connectez vous !");
            try {
                Thread.sleep(5000);
                MainFrameController.showWelcomeView();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Échec lors de la création de votre compte ! Veuillez réessayer");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
