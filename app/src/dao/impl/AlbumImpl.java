package dao.impl;

import dao.AlbumDAO;
import dao.DatabaseConnection;
import dao.models.Album;
import dao.models.Artiste;
import dao.models.Titre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class AlbumImpl implements AlbumDAO {
    String table = "album";

    @Override
    public ArrayList<Album> getUserAlbums(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Album> albumsUser = new ArrayList<Album>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "liste_album", clauses);
            if (!rs.isBeforeFirst()){
                return albumsUser;
            } else {
                while (rs.next()){
                    albumsUser.add(getAlbum(rs.getString("nomAlbum")));
                }
                return albumsUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return albumsUser;
        }
    }

    public Album getAlbum(String nomAlbum) {
        nomAlbum = nomAlbum.replace("'", "''"); // Handling ' case
        String clauses = "nom='" + nomAlbum + "'";
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                Album tmpAlbum = new Album();
                while (rs.next()){
                    tmpAlbum.setNom(rs.getString("nom"));
                    tmpAlbum.setAnnee(rs.getInt("annee"));
                    tmpAlbum.setArtiste(rs.getString("nomArtiste"));
                    int duree = 0;
                    for (Titre titre : tmpAlbum.getTitres()) {
                        duree += titre.getDuree();
                    }
                    tmpAlbum.setDuree(duree);

                }
                return tmpAlbum;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Album> getArtisteAlbums(String nomArtiste) {
        nomArtiste = nomArtiste.replace("'", "''"); // Handling ' case
        String clauses = "nomArtiste='" + nomArtiste + "'";
        ArrayList<Album> albumsArtiste = new ArrayList<Album>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return albumsArtiste;
            } else {
                while (rs.next()){
                    albumsArtiste.add(getAlbum(rs.getString("nom")));
                }
                return albumsArtiste;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return albumsArtiste;
        }
    }

    public ArrayList<Album> rechercherAlbums(String substring) {
        substring = substring.replace("'", "''"); // Handling ' case
        String clauses = "strpos(lower(replace(nom, ' ', '')), '" + substring.toLowerCase().replace(" ", "") + "') > 0;";
        ArrayList<Album> resultatsRecherche = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return resultatsRecherche;
            } else {
                while (rs.next()){
                    resultatsRecherche.add(getAlbum(rs.getString("nom")));
                }
                return resultatsRecherche;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return resultatsRecherche;
        }
    }

    public boolean albumExiste(String nomAlbum) {
        String clauses = "nom='" + nomAlbum + "'";
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            return rs.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean creerAlbum(String nomAlbum, String nomArtiste, int annee) {
        String values = "'" + nomAlbum + "', '" + nomArtiste + "', " + annee;
        try {
            return DatabaseConnection.insert(values , this.table);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
