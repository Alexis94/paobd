package views;

import dao.models.User;

import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ProfilView {
    public ProfilView(User user, Scanner in) {
        System.out.println("Salut " + user.getPseudo());
        System.out.println("1. Voir Titres");
        System.out.println("2. Voir Artistes");
        System.out.println("3. Voir Albums\n");

        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3){
            n = in.nextInt();
        }

        if (n == 1){
            MainFrameController.showListeTitresView();
        } else if (n == 2) {
            MainFrameController.showListeArtistesView();
        } else {
            MainFrameController.showListeAlbumsView(user);
        }

    }
}
