package dao.impl;

import dao.DatabaseConnection;
import dao.EcouteDAO;
import dao.models.Ecoute;
import dao.models.Titre;
import utils.GenreMusique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alexis on 13/11/2016.
 */
public class EcouteImpl implements EcouteDAO {
    String table = "ecoute";
    @Override
    public ArrayList<Ecoute> getUserEcoute(String pseudo) {
            String clauses = "pseudoUser='" + pseudo + "' order by dateecoute desc;";
            ArrayList<Ecoute> ecoutesUser = new ArrayList<>();
            try {
                ResultSet rs = DatabaseConnection.get("*", this.table, clauses);
                if (!rs.isBeforeFirst()){
                    return ecoutesUser;
                } else {
                    while (rs.next()){
                        Ecoute tmpEcoute = new Ecoute();
                        tmpEcoute.setTitre(new TitreImpl().getTitre(rs.getString("titreId")));
                        tmpEcoute.setDateEcoute(rs.getString("dateEcoute"));
                        ecoutesUser.add(tmpEcoute);
                    }
                    return ecoutesUser;
                }


            } catch (SQLException e) {
                e.printStackTrace();
                return ecoutesUser;
            }
    }


    public boolean ajouterEcoute(String pseudo, int titreId) {
        String values = "'" + pseudo + "', DEFAULT, " + titreId;
        try {
            return DatabaseConnection.insert(values, this.table);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerEcoute(String pseudo, String dateecoute) {
        String clauses = "pseudoUser='" + pseudo + "' AND dateEcoute='" + dateecoute + "'";
        try {
            return DatabaseConnection.delete(this.table, clauses);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Titre> getUserRecommendations(String pseudo) {
        String requete = "select * from (select * from titre where id not in (select titreid as id from ecoute where pseudouser='" + pseudo + "')) as titre inner join (select genre, nomartiste from titre inner join (select titreId as id from ecoute where pseudouser='"+ pseudo +"') as titresecoutes on titre.id = titresecoutes.id) as res on titre.genre=res.genre OR titre.nomartiste=res.nomartiste ORDER BY RANDOM() limit 10;";
        ArrayList<Titre> recommendationTitres = new ArrayList<>();
        try {
            ResultSet rs = DatabaseConnection.query(requete);
            if (!rs.isBeforeFirst()){
                return recommendationTitres;
            } else {
                while (rs.next()){
                    Titre tmpTitre = new Titre();
                    tmpTitre.setId(rs.getInt("id"));
                    tmpTitre.setNom(rs.getString("nom"));
                    tmpTitre.setAlbum(rs.getString("nomAlbum"));
                    tmpTitre.setArtiste(rs.getString("nomArtiste"));
                    tmpTitre.setDuree(rs.getInt("duree"));
                    tmpTitre.setGenre(GenreMusique.valueOf(rs.getString("genre").toUpperCase()));
                    recommendationTitres.add(tmpTitre);
                }
                return recommendationTitres;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
