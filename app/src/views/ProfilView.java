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
        System.out.println("3. Voir Albums");
        System.out.println("4. Voir Playlists");
        System.out.println("5. Rechercher\n");

        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3 && n != 4 && n != 5){
            n = in.nextInt();
        }

        if (n == 1){
            MainFrameController.showListeTitresView();
        } else if (n == 2) {
            MainFrameController.showListeArtistesView();
        } else if (n == 3){
            MainFrameController.showListeAlbumsView(user);
        } else if (n == 4){
            MainFrameController.showListePlaylistsView();
        } else if (n == 5){
            MainFrameController.showRechercherView();
        }

        //TODO Menu Écoute -- Ajouter/retirer écoute dedans
    }
}
