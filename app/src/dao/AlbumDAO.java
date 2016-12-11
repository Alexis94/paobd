package dao;

import dao.models.Album;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface AlbumDAO {

    ArrayList<Album> getUserAlbums(String pseudo);
    Album getAlbum(String nomAlbum);
}
