package dao.impl;

import dao.DatabaseConnection;
import dao.TitreDAO;
import dao.models.Album;
import dao.models.Titre;
import utils.GenreMusique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class TitreImpl implements TitreDAO {
    String table = "titre";
    public ArrayList<Titre> getUserTitres(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Titre> titresUser = new ArrayList<Titre>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "liste_titre", clauses);
            if (!rs.isBeforeFirst()){
                return titresUser;
            } else {
                while (rs.next()){
                    titresUser.add(getTitre(rs.getString("titreId")));
                }
                return titresUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return titresUser;
        }
    }

    public ArrayList<Titre> getAlbumTitres(String nomAlbum) {
        String clauses = "nomAlbum='" + nomAlbum + "';";
        ArrayList<Titre> titresAlbum = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return titresAlbum;
            } else {
                while (rs.next()){
                    titresAlbum.add(getTitre(rs.getString("id")));
                }
                return titresAlbum;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return titresAlbum;
        }
    }

    public Titre getTitre(String titreId) {
        String clauses = "id='" + titreId + "'";
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                Titre tmpTitre = new Titre();
                while (rs.next()){
                    tmpTitre.setNom(rs.getString("nom"));
                    tmpTitre.setAlbum(new Album(rs.getString("nomAlbum")));
                    tmpTitre.setArtiste(new ArtisteImpl().getArtiste(rs.getString("nomArtiste")));
                    tmpTitre.setDuree(rs.getInt("duree"));
                    tmpTitre.setGenre(GenreMusique.valueOf(rs.getString("genre").toUpperCase()));
                }
                return tmpTitre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Titre> rechercherTitres(String substring) {
        String clauses = "strpos(lower(replace(nom, ' ', '')), '" + substring.toLowerCase().replace(" ", "") + "') > 0;";
        ArrayList<Titre> resultatsRecherche = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return resultatsRecherche;
            } else {
                while (rs.next()){
                    resultatsRecherche.add(getTitre(rs.getString("id")));
                }
                return resultatsRecherche;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return resultatsRecherche;
        }
    }
}
