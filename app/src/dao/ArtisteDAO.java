package dao;

import dao.models.Artiste;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface ArtisteDAO {
    Artiste getArtiste(String nomArtiste);

    ArrayList<Artiste> getUserArtistes(String pseudo);

    ArrayList<Artiste> rechercherArtistes(String substring);

    boolean artisteExiste(String nomArtiste);

    boolean creerArtiste(String nomArtiste, String nationaliteArtiste);

    boolean ajouterArtisteUser(String pseudo, String nomArtiste);

    boolean retirerArtisteUser(String pseudo, String nomArtiste);
}
