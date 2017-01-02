package views;

import dao.impl.PlaylistImpl;
import dao.models.Playlist;
import dao.models.User;

import java.util.Scanner;

/**
 * Created by Alexis on 17/12/2016.
 */
public class ListePlaylistsView {
    public ListePlaylistsView(Scanner in, User user) {
        int i = 0;
        for (Playlist playlist : user.getPlaylists()) {
            System.out.print(++i + ". ");
            playlist.print();
        }

        System.out.println("\n1. Voir une playlist");
        System.out.println("2. Créer Playlist");
        System.out.println("3. Supprimer Playlist");
        System.out.println("4. Retourner au profil");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4) {
            n = in.nextInt();
        }

        PlaylistImpl playlistImpl = new PlaylistImpl();
        if (n == 1) {
            System.out.print("ID de la playlist: ");
            int playlistId = in.nextInt();
            MainFrameController.showPlaylistView(user.getPlaylists().get(playlistId - 1));
        } else if (n == 2) {
            System.out.print("Nom de la playlist: ");
            String nomPlaylist = in.nextLine();
            nomPlaylist = in.nextLine();
            if (playlistImpl.creerPlaylist(nomPlaylist, user.getPseudo())) {
                System.out.println("Playlist créée avec succès");
                user.ajouterPlaylist(playlistImpl.getPlaylist(playlistImpl.getDernierId()));
                MainFrameController.showListePlaylistsView();
            } else {
                System.out.println("Échec lors de la création de la playlist");
                MainFrameController.showListePlaylistsView();
            }
        } else if (n == 3) {
            System.out.print("Numéro de la playlist: ");
            int numeroPlaylist = in.nextInt();
            if (new PlaylistImpl().supprimerPlaylist(user.getPlaylists().get(numeroPlaylist - 1).getId())) {
                user.retirerPlaylist(user.getPlaylists().get(numeroPlaylist - 1));
                System.out.println("Playlist supprimée avec succès");
                MainFrameController.showListePlaylistsView();
            } else {
                System.out.println("Échec lors de la suppression de la playlist");
            }
        } else {
            MainFrameController.showProfil();
        }
    }


}
