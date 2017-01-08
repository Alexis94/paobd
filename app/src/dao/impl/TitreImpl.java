package dao.impl;

import dao.DatabaseConnection;
import dao.TitreDAO;
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

    @Override
    public ArrayList<Titre> getUserTitres(String pseudo) {
        String clauses = "pseudoUser='" + pseudo + "';";
        ArrayList<Titre> titresUser = new ArrayList<Titre>();
        try {
            ResultSet rs = DatabaseConnection.get("*", "liste_titre", clauses);
            if (!rs.isBeforeFirst()) {
                return titresUser;
            } else {
                while (rs.next()) {
                    titresUser.add(getTitre(rs.getString("titreId")));
                }
                return titresUser;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return titresUser;
        }
    }

    @Override
    public ArrayList<Titre> getAlbumTitres(String nomAlbum) {
        nomAlbum = nomAlbum.replace("'", "''");
        String clauses = "nomAlbum='" + nomAlbum + "';";
        ArrayList<Titre> titresAlbum = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()) {
                return titresAlbum;
            } else {
                while (rs.next()) {
                    titresAlbum.add(getTitre(rs.getString("id")));
                }
                return titresAlbum;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return titresAlbum;
        }
    }

    @Override
    public Titre getTitre(String titreId) {
        String clauses = "id=" + titreId;
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                Titre tmpTitre = new Titre();
                while (rs.next()) {
                    tmpTitre.setId(rs.getInt("id"));
                    tmpTitre.setNom(rs.getString("nom"));
                    tmpTitre.setAlbum(rs.getString("nomAlbum"));
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

    @Override
    public ArrayList<Titre> rechercherTitres(String substring) {
        substring = substring.replace("'", "''"); // Handling ' case
        String clauses = "strpos(lower(replace(nom, ' ', '')), '" + substring.toLowerCase().replace(" ", "") + "') > 0;";
        ArrayList<Titre> resultatsRecherche = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
            if (!rs.isBeforeFirst()) {
                return resultatsRecherche;
            } else {
                while (rs.next()) {
                    resultatsRecherche.add(getTitre(rs.getString("id")));
                }
                return resultatsRecherche;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return resultatsRecherche;
        }
    }

    @Override
    public boolean retirerTitreUser(String pseudo, int titreId) {
        String clauses = "pseudoUser='" + pseudo + "' AND titreId=" + titreId;
        try {
            return DatabaseConnection.delete("liste_titre", clauses);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean ajouterTitreUser(String pseudo, String titreId) {
        String values = "'" + pseudo + "'" + ", '" + titreId + "'";
        try {
            return DatabaseConnection.insert(values, "liste_titre");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean creerTitre(String nomTitre, int duree, String nomArtiste, String nomAlbum, String genre) {
        String values = "DEFAULT, '" + nomTitre + "'" + ", " + duree + ", '" + nomAlbum + "', '" + genre.toLowerCase() + "'";
        try {
            return DatabaseConnection.insert(values, this.table);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getDernierId() {
        try {
            ResultSet rs = DatabaseConnection.query("select currval('TITRE_SEQ')");
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
}
