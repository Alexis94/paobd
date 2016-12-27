package views;

import dao.impl.EcouteImpl;
import dao.models.Ecoute;
import dao.models.User;
import sun.applet.Main;

import java.util.Scanner;

/**
 * Created by Alexis on 27/12/2016.
 */
public class EcouteView {
    public EcouteView(Scanner in) {
        User user = MainFrameController.user;
        System.out.println("----- LISTE ÉCOUTES -----");
        int i = 0;
        for (Ecoute ecoute : user.getEcoutes()) {
            System.out.print(++i + ". ");
            ecoute.print();
        }

        System.out.println("\n1. Ajouter une écoute");
        System.out.println("2. Retirer une écoute");
        System.out.println("3. Voir recommendations basées sur les dernières écoutes");
        System.out.println("4. Revenir au profil\n");

        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3 && n != 4){
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Id du titre: ");
            int titreId = in.nextInt();
            if (new EcouteImpl().ajouterEcoute(user.getPseudo(), titreId)) {
                System.out.println("Ecoute rajoutée avec succès");
            } else {
                System.out.println("Echec lors de l'ajout de l'écoute");
            }
            MainFrameController.showEcoutesView();
        } else if (n == 2) {
            System.out.print("Id du titre: ");
            int titreId = in.nextInt();
            if (new EcouteImpl().supprimerEcoute(user.getPseudo(), user.getEcoutes().get(titreId - 1).getDateEcoute())) {
                System.out.println("Ecoute retirée avec succès");
            } else {
                System.out.println("Echec lors de la suppression de l'écoute");
            }
            MainFrameController.showEcoutesView();
        } else if (n == 4) {

        } else {
            MainFrameController.showProfil();
        }



    }
}
