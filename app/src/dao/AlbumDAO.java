package dao;

import dao.models.Album;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface AlbumDAO {
    ArrayList<Album> getUserAlbums(String pseudo);

    Album getAlbum(String nomAlbum);

    ArrayList<Album> getArtisteAlbums(String nomArtiste);

    ArrayList<Album> rechercherAlbums(String substring);

    boolean albumExiste(String nomAlbum);

    boolean creerAlbum(String nomAlbum, String nomArtiste, int annee);

    boolean ajouterAlbumUser(String pseudo, String nomAlbum);

    boolean retirerAlbumUser(String pseudo, String nomAlbum);

}
