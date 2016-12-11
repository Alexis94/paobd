package views;

import java.util.Scanner;

/**
 * Created by Alexis on 21/11/2016.
 */
public class WelcomeView {
    public WelcomeView(Scanner in){


        System.out.println("------------------------------------------");
        System.out.println("| Bienvenue dans votre librarie Musicale |");
        System.out.println("1. Se Connecter");
        System.out.println("2. Créer un compte\n");
        int n = in.nextInt();

        while(n != 1 && n != 2){
            n = in.nextInt();
        }

        if (n == 1){
            MainFrameController.showSeConnecterView();
        } else {
            MainFrameController.showCreerCompteView();
        }
    }
    /*public WelcomeView() {
        JButton seConnecter = new JButton("Se Connecter");
        JButton creerCompte = new JButton("Créer un compte");

        seConnecter.setActionCommand("seConnecter");
        creerCompte.setActionCommand("creerCompte");

        this.add(seConnecter);
        this.add(creerCompte);
        this.setVisible(true);

        seConnecter.addActionListener(this);
        creerCompte.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "seConnecter")) {
            MainFrameController.setView(new SeConnecterView());

        } else if (Objects.equals(e.getActionCommand(), "creerCompte")) {
            MainFrameController.setView(new CreerCompteView());
        }
    }*/
}
