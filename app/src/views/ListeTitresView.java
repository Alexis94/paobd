package views;

import dao.models.Titre;
import dao.models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeTitresView {
    public ListeTitresView(Scanner in, User user) {
        for (Titre titre : user.getTitres()) {
            titre.print();
        }

        System.out.print("Pressez entrez pour revenir au profil: ");
        String entry = in.nextLine();

        MainFrameController.showProfil();
    }

    public ListeTitresView(Scanner in, ArrayList<Titre> titres) {
        for (Titre titre : titres) {
            titre.print();
        }

        System.out.print("Pressez entrez pour revenir au profil: ");
        String entry = in.nextLine();

        MainFrameController.showProfil();
    }
}
