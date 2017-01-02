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
        int i = 0;
        for (Titre titre : playlist.getTitres()) {
            System.out.print(++i + ". ");
            titre.print();
        }

        System.out.println("\n1. Ajouter titre à la playlist");
        System.out.println("2. Retirer titre à la playlist");
        System.out.println("3. Revenir à la liste des playlists");
        System.out.println("4. Revenir au menu");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4) {
            n = in.nextInt();
        }

        if (n == 1) {
            MainFrameController.showAjouterTitreView(playlist.getId());
        } else if (n == 2) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            if (playlist.supprimerTitre(playlist.getTitres().get(titreId - 1))) {
                MainFrameController.showPlaylistView(playlist);
            } else {
                System.out.println("Erreur lors de la suppression du titre de la playlist");
            }
        } else if (n == 3) {
            MainFrameController.showListePlaylistsView();
        } else {
            MainFrameController.showProfil();
        }


        //TODO Ajouter titre à Playlist
        //TODO Retirer titre à Playlist

    }
}
