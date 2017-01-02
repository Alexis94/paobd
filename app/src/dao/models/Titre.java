package dao.models;

import utils.GenreMusique;

import static utils.Utils.formatDuree;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Titre {
    private int id;
    private String nom;
    private int duree;
    private GenreMusique genre;
    private String artiste;
    private String album;

    public Titre(int id, String nom, int duree, GenreMusique genre, String artiste, String album) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.genre = genre;
        this.artiste = artiste;
        this.album = album;
    }

    public Titre() {

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

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void print() {
        System.out.println(this.getNom() + " - " + this.getArtiste() + " - " + this.getAlbum() + " - " + this.getGenre() + " - " + formatDuree(this.getDuree()));
    }

    public void printWithId() {
        System.out.println(this.getId() + " - " + this.getNom() + " - " + this.getArtiste() + " - " + this.getAlbum() + " - " + this.getGenre() + " - " + formatDuree(this.getDuree()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
