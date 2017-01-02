package dao;

import dao.models.Playlist;
import dao.models.Titre;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface PlaylistDAO {
    ArrayList<Playlist> getUserPlaylists(String pseudo);

    ArrayList<Titre> getPlaylistTitres(int playlistId);

    Playlist getPlaylist(int id);

    boolean creerPlaylist(String nomPlaylist, String pseudoUser);

    boolean supprimerPlaylist(int playlistId);

    int getDernierId();

    boolean ajouterTitre(int playlistId, int titreId);

    boolean retirerTitre(int playlistId, int titreId);
}
