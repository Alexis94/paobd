package views;

import dao.impl.TitreImpl;
import dao.models.Titre;
import dao.models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeTitresView {
    public ListeTitresView(Scanner in, User user) {
        //TODO Sort titres
        int i = 0;
        for (Titre titre : user.getTitres()) {
            System.out.print(++i + ".");
            titre.print();
        }

        System.out.println("1. Ajouter titre");
        System.out.println("2. Retirer titre");
        System.out.println("3. Importer titres");
        System.out.println("4. Retourner au profil");
        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3 && n != 4){
            n = in.nextInt();
        }

        if (n == 1){
            MainFrameController.showAjouterTitreView();
        } else if (n == 2){
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            if (new TitreImpl().retirerTitreUser(user.getPseudo(), user.getTitres().get(titreId - 1).getId())) {
                user.retirerTitre(user.getTitres().get(titreId-1));
                MainFrameController.showListeTitresView();
            } else {
                System.out.println("Erreur lors de la suppression du titre de la bibliothèque personnelle");
            }
        } else if (n == 3){
            //TODO JFileChooser
        } else if (n == 4) {
            MainFrameController.showProfil();
        }


    }

    public ListeTitresView(Scanner in, ArrayList<Titre> titres) {
        for (Titre titre : titres) {
            titre.printWithId();
        }
        //TODO Ajouter Titre directement collection
        //TODO Ajouter Titre à une playlist
        System.out.print("Pressez entrez pour revenir au profil: ");
        String entry = in.nextLine();
        entry = in.nextLine();

        MainFrameController.showProfil();
    }
}
