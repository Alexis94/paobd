package views;

import dao.models.Album;
import dao.models.Titre;

import java.util.Scanner;

/**
 * Created by Alexis on 05/12/2016.
 */
public class AlbumView {
    public AlbumView(Scanner in, Album album) {
        album.print();
        for (Titre titre : album.getTitres()) {
            titre.print();
        }

        System.out.print("Pressez entrez pour revenir au profil: ");
        String entry = in.nextLine();

        MainFrameController.showProfil();
    }
}
