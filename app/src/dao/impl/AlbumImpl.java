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
        String clauses = "nom='" + nomAlbum + "';";
        Album tmpAlbum = new Album();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                while (rs.next()){
                    tmpAlbum.setNom(rs.getString("nom"));
                    tmpAlbum.setAnnee(rs.getInt("annee"));
                    tmpAlbum.setArtiste(new ArtisteImpl().getArtiste(rs.getString("nomArtiste")));
                    int duree = 0;
                    for (Titre titre : new TitreImpl().getAlbumTitres(rs.getString("nom"))) {
                        tmpAlbum.ajouterTitre(titre);
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
        String clauses = "nomArtiste='" + nomArtiste + "';";
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
}
