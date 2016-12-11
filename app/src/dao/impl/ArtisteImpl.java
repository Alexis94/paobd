package dao.impl;

import dao.ArtisteDAO;
import dao.DatabaseConnection;
import dao.models.Artiste;
import dao.models.Titre;
import utils.GenreMusique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class ArtisteImpl implements ArtisteDAO {
    String table = "artiste";
    public Artiste getArtiste(String nomArtiste) {
        String clauses = "nom='" + nomArtiste + "'";
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                Artiste tmpArtiste = new Artiste();
                while (rs.next()){
                    tmpArtiste.setNom(rs.getString("nom"));
                    tmpArtiste.setNationalite(rs.getString("nationalite"));
                    tmpArtiste.setAlbums()
                }
                return tmpArtiste;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Artiste> getUserArtistes(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Artiste> artistesUser = new ArrayList<Artiste>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "liste_artiste", clauses);
            if (!rs.isBeforeFirst()){
                return artistesUser;
            } else {
                while (rs.next()){
                    artistesUser.add(getArtiste(rs.getString("nomArtiste")));
                }
                return artistesUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return artistesUser;
        }
    }
}
