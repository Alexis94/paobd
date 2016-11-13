package dao.models;

import utils.GenreMusique;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Titre {
    String nom;
    int duree;
    GenreMusique genre;
    Artiste artiste;
    Album album;

    public Titre(String nom, int duree, GenreMusique genre, Artiste artiste, Album album) {
        this.nom = nom;
        this.duree = duree;
        this.genre = genre;
        this.artiste = artiste;
        this.album = album;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public GenreMusique getGenre() {
        return genre;
    }

    public void setGenre(GenreMusique genre) {
        this.genre = genre;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
