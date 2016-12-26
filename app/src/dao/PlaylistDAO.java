package dao;

import dao.models.Playlist;
import dao.models.Titre;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface PlaylistDAO {
    ArrayList<Playlist> getUserPlaylists(String pseudo);
    ArrayList<Titre> getPlaylistTitres(String playlistId);
}
