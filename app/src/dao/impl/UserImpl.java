package dao.impl;

import dao.DatabaseConnection;
import dao.UserDAO;
import dao.models.*;
import utils.Utils;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexis on 13/11/2016.
 */
public class UserImpl implements UserDAO {
    String table = "utilisateur";

    @Override
    public boolean ajouterUser(User user) {

        try {
            String values = "'" + user.getPseudo() + "', '" + Utils.hashPassword(user.getPassword()) + "', '" + user.getNom() + "', '" + user.getPrenom() + "', '" + Integer.toString(user.getAge()) + "'";
            return DatabaseConnection.insert(values, this.table);
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public User seConnecter(String pseudo, String password) {
        try {
            String clauses = "pseudo='" + pseudo + "' AND motDePasse='" + Utils.hashPassword(password) + "'";

            ResultSet rs = DatabaseConnection.get(" * ", this.table, clauses);
            User user = new User();
            if (!rs.isBeforeFirst()) {
                System.out.println("Wrong password and/or email");
                return null;
            } else {
                while (rs.next()) {
                    user.setPseudo(rs.getString("pseudo"));
                    user.setPassword(rs.getString("motDePasse"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("prenom"));
                    user.setAge(rs.getInt("age"));
                }
                for (Titre titre : new TitreImpl().getUserTitres(user.getPseudo())) {
                    user.ajouterTitre(titre);
                }
                for (Artiste artiste : new ArtisteImpl().getUserArtistes(user.getPseudo())) {
                    user.ajouterArtiste(artiste);
                }
                for (Playlist playlist : new PlaylistImpl().getUserPlaylists(user.getPseudo())) {
                    user.ajouterPlaylist(playlist);
                }
                for (Album album : new AlbumImpl().getUserAlbums(user.getPseudo())) {
                    user.ajouterAlbum(album);
                }
                return user;
            }


        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
