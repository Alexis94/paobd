package dao;

import dao.models.Artiste;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface ArtisteDAO {
    Artiste getArtiste(String nomArtiste);
    ArrayList<Artiste> getUserArtistes(String pseudo);
}
