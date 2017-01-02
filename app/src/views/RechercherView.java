package views;

import dao.impl.AlbumImpl;
import dao.impl.ArtisteImpl;
import dao.impl.TitreImpl;

import java.util.Scanner;

/**
 * Created by Alexis on 11/12/2016.
 */
public class RechercherView {
    public RechercherView(Scanner in) {
        System.out.println("##### Interface de recherche ######");
        System.out.println("1. Rechercher un titre");
        System.out.println("2. Rechercher un album");
        System.out.println("3. Rechercher un artiste");
        System.out.println("4. Retourner au profil\n");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4) {
            n = in.nextInt();
        }
        if (n != 4) {
            System.out.print("Rechercher: ");
            String recherche = in.nextLine();
            recherche = in.nextLine();
            if (n == 1) {
                MainFrameController.showListeTitresView(new TitreImpl().rechercherTitres(recherche));
            } else if (n == 2) {
                MainFrameController.showListeAlbumsView(new AlbumImpl().rechercherAlbums(recherche));
            } else if (n == 3) {
                MainFrameController.showListeArtistesView(new ArtisteImpl().rechercherArtistes(recherche));
            }
        } else {
            MainFrameController.showProfil();
        }

        //TODO Consulter USER?


    }
}
