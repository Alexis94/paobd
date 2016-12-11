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
}
