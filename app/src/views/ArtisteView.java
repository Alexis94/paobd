package views;

import dao.impl.AlbumImpl;
import dao.models.Album;
import dao.models.Artiste;

import java.util.Scanner;

/**
 * Created by Alexis on 06/12/2016.
 */
public class ArtisteView {
    public ArtisteView(Scanner in, Artiste artiste) {

        for (Album album : artiste.getAlbums()) {
            album.print();
        }

        System.out.println("\n1. Voir un album");
        System.out.println("2. Retourner au profil");

        int n = in.nextInt();

        while (n != 1 && n != 2) {
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            nomAlbum = in.nextLine();
            MainFrameController.showAlbumView(new AlbumImpl().getAlbum(nomAlbum));
        } else {
            MainFrameController.showProfil();
        }
    }
}
