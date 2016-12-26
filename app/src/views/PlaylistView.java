package views;

import dao.models.Playlist;
import dao.models.Titre;

import java.util.Scanner;

/**
 * Created by Alexis on 17/12/2016.
 */
public class PlaylistView {
    public PlaylistView(Scanner in, Playlist playlist) {
        playlist.print();
        for (Titre titre : playlist.getTitres()) {
            titre.print();
        }

        System.out.print("Pressez entrez pour revenir au profil: ");
        String entry = in.nextLine();

        MainFrameController.showProfil();
        //TODO Ajouter titre à Playlist
        //TODO Retirer titre à Playlist

    }
}
