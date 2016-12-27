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
    private String table = "playlist";
    public ArrayList<Playlist> getUserPlaylists(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Playlist> playlistsUser = new ArrayList<Playlist>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist", clauses);
            if (!rs.isBeforeFirst()){
                return playlistsUser;
            } else {
                while (rs.next()){
                    playlistsUser.add(getPlaylist(rs.getInt("id")));
                }
                return playlistsUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return playlistsUser;
        }
    }

    public ArrayList<Titre> getPlaylistTitres(int playlistId) {
        String clauses = "playlistId=" + playlistId + "";
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

    public Playlist getPlaylist(int id) {
        String clauses = "id=" + id + "";
        Playlist playlist = new Playlist();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist", clauses);
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    playlist.setId(rs.getInt("id"));
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

    public boolean creerPlaylist(String nomPlaylist, String pseudoUser) {
        String values = "DEFAULT, '" + nomPlaylist + "'" + ", '" + pseudoUser + "'";
        try {
            return DatabaseConnection.insert(values, this.table);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerPlaylist(int playlistId) {
        String clauses = "id=" + playlistId;
        try {
            return DatabaseConnection.delete("playlist", clauses);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getDernierId() {
        try {
            ResultSet rs = DatabaseConnection.query("select currval('PLAYLIST_SEQ')");
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public boolean ajouterTitre(int playlistId, int titreId) {
        String values = titreId + ", " + playlistId;
        try {
            return DatabaseConnection.insert(values ,"playlist_titre");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retirerTitre(int playlistId, int titreId) {
        String values = "titreId=" + titreId + " AND playlistId=" + playlistId;
        try {
            return DatabaseConnection.delete("playlist_titre", values);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
