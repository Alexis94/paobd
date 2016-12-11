package dao.models;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Artiste {
    String nom;
    String nationalite;
    ArrayList<Album> albums;

    public Artiste(String nom, String nationalite, ArrayList<Titre> titres, ArrayList<Album> albums) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.albums = albums;
    }

    public Artiste() {
        this.albums = new ArrayList<Album>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void ajouterAlbum(Album album) {
        this.albums.add(album);
    }

    public void retirerAlbum(Album album) {
        this.albums.remove(album);
    }

    public void print() {
        System.out.println(this.getNom() + " - " + this.getNationalite());
    }
}
