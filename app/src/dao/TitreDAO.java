package dao;

import dao.models.Titre;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface TitreDAO {
    ArrayList<Titre> getUserTitres(String pseudo);

    ArrayList<Titre> getAlbumTitres(String nomAlbum);

    Titre getTitre(String titreId);

    ArrayList<Titre> rechercherTitres(String substring);

    boolean retirerTitreUser(String pseudo, int titreId);

    boolean ajouterTitreUser(String pseudo, String titreId);

    boolean creerTitre(String nomTitre, int duree, String nomArtiste, String nomAlbum, String genre);

    int getDernierId();
}
