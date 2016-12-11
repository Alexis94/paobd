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
        Playlist playlistTmp = new Playlist();
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Playlist> playlistsUser = new ArrayList<Playlist>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist", clauses);
            if (!rs.isBeforeFirst()){
                return playlistsUser;
            } else {
                while (rs.next()){
                    playlistTmp.setNom(rs.getString("nom"));
                    playlistTmp.setId(rs.getString("id"));
                    playlistTmp.setPseudoUser(rs.getString("pseudoUser"));
                    for (String titreId : getPlaylistTitresIds(playlistTmp.getId())) {
                        playlistTmp.ajouterTitre(new TitreImpl().getTitre(titreId));
                    }
                    int duree = 0;
                    for (Titre titre : playlistTmp.getTitres()) {
                        duree += titre.getDuree();
                    }
                    playlistTmp.setDuree(duree);
                }
                return playlistsUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return playlistsUser;
        }
    }
    public ArrayList<String> getPlaylistTitresIds(String playlistId) {
        String clauses = "playlistId='" + playlistId + "';";
        ArrayList<String> playlistsTitresIds = new ArrayList<String>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "playlist_titre", clauses);
            if (!rs.isBeforeFirst()){
                return playlistsTitresIds;
            } else {
                while (rs.next()){
                    playlistsTitresIds.add(rs.getString("titreId"));
                }
                return playlistsTitresIds;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return playlistsTitresIds;
        }
    }
}
