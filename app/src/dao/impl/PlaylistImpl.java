package dao.impl;

import dao.DatabaseConnection;
import dao.PlaylistDAO;
import dao.TitreDAO;
import dao.models.Playlist;
import dao.models.Titre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class PlaylistImpl implements PlaylistDAO {
    public ArrayList<Playlist> getUserPlaylists(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Playlist> playlistsUser = new ArrayList<Playlist>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist", clauses);
            if (!rs.isBeforeFirst()){
                return playlistsUser;
            } else {
                while (rs.next()){
                    playlistsUser.add(getPlaylist(rs.getString("id")));
                }
                return playlistsUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return playlistsUser;
        }
    }

    public ArrayList<Titre> getPlaylistTitres(String playlistId) {
        String clauses = "playlistId='" + playlistId + "';";
        ArrayList<Titre> playlistTitres = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist_titre", clauses);
            if (!rs.isBeforeFirst()){
                return playlistTitres;
            } else {
                while (rs.next()){
                    playlistTitres.add(new TitreImpl().getTitre(rs.getString("titreId")));
                }
                return playlistTitres;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return playlistTitres;
        }
    }

    public Playlist getPlaylist(String id) {
        String clauses = "id='" + id + "';";
        Playlist playlist = new Playlist();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist", clauses);
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    playlist.setId(rs.getString("id"));
                    playlist.setNom(rs.getString("nom"));
                    playlist.setPseudoUser("pseudoUser");
                    int duree = 0;
                    for (Titre titre : playlist.getTitres()) {
                        duree += titre.getDuree();
                    }
                    playlist.setDuree(duree);
                }
                return playlist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
