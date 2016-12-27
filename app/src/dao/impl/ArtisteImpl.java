package dao.impl;

import dao.ArtisteDAO;
import dao.DatabaseConnection;
import dao.models.Album;
import dao.models.Artiste;
import dao.models.Titre;
import utils.GenreMusique;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class ArtisteImpl implements ArtisteDAO {
    String table = "artiste";
    public Artiste getArtiste(String nomArtiste) {
        nomArtiste = nomArtiste.replace("'", "''"); // Handling ' case
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
        Artiste artisteTmp = new Artiste();
        ArrayList<Artiste> artistesUser = new ArrayList<>();
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

    public ArrayList<Artiste> rechercherArtistes(String substring) {
        substring = substring.replace("'", "''"); // Handling ' case
        String clauses = "strpos(lower(replace(nom, ' ', '')), '" + substring.toLowerCase().replace(" ", "") + "') > 0;";
        ArrayList<Artiste> resultatsRecherche = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()){
                return resultatsRecherche;
            } else {
                while (rs.next()){
                    resultatsRecherche.add(getArtiste(rs.getString("nom")));
                }
                return resultatsRecherche;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return resultatsRecherche;
        }
    }

    public boolean artisteExiste(String nomArtiste) {
        String clauses = "nom='" + nomArtiste + "'";
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            return rs.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean creerArtiste(String nomArtiste, String nationaliteArtiste) {
        String values = "'" + nomArtiste + "'" + ", '" + nationaliteArtiste + "'";
        try {
            return DatabaseConnection.insert(values ,"artiste");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean ajouterArtisteUser(String pseudo, String nomArtiste) {
        String values = "'" + pseudo + "'" + ", '" + nomArtiste + "'";
        try {
            return DatabaseConnection.insert(values ,"liste_artiste");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retirerArtisteUser(String pseudo, String nomArtiste) {
        nomArtiste = nomArtiste.replace("'", "''");
        String clauses = "pseudoUser='" + pseudo + "' AND nomArtiste='" + nomArtiste + "'";
        try {
            return DatabaseConnection.delete("liste_artiste", clauses);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
