package views;

import dao.impl.AlbumImpl;
import dao.impl.ArtisteImpl;
import dao.models.Artiste;
import dao.models.User;

import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeArtistesView {
    public ListeArtistesView(Scanner in, User user){
        for (Artiste artiste : user.getArtistes()) {
            artiste.print();
        }
        System.out.println("\n1. Voir un artiste");
        System.out.println("2. Retourner au profil");

        int n = in.nextInt();

        while(n != 1 && n != 2){
            n = in.nextInt();
        }

        if (n == 1){
            System.out.print("Nom de l'artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            MainFrameController.showArtisteView(new ArtisteImpl().getArtiste(nomArtiste));
        } else {
            MainFrameController.showProfil();
        }
    }
}
