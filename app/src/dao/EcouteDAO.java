package dao;

import dao.models.Ecoute;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface EcouteDAO {
    ArrayList<Ecoute> getUserEcoute(String pseudo);
}
