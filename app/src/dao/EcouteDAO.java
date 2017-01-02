package dao;

import dao.models.Ecoute;
import dao.models.Titre;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface EcouteDAO {
    ArrayList<Ecoute> getUserEcoute(String pseudo);

    boolean ajouterEcoute(String pseudo, int titreId);

    boolean supprimerEcoute(String pseudo, String dateecoute);

    ArrayList<Titre> getUserRecommendations(String pseudo);
}
