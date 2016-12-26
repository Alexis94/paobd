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
        for (Playlist playlist : user.getPlaylists()) {
            playlist.print();
        }

        System.out.println("\n1. Voir une playlist");
        System.out.println("2. Retourner au profil");

        int n = in.nextInt();

        while(n != 1 && n != 2){
            n = in.nextInt();
        }

        if (n == 1){
            System.out.print("ID de la playlist: ");
            String playlistId = in.nextLine();
            playlistId = in.nextLine();
            MainFrameController.showPlaylistView(new PlaylistImpl().getPlaylist(playlistId));
        } else {
            MainFrameController.showProfil();
        }
        //TODO Créer Playlist
        //TODO Supprimer Playlist
    }


}
