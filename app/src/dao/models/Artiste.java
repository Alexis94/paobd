package dao.models;

import dao.impl.AlbumImpl;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Artiste {
    private String nom;
    private String nationalite;

    public Artiste(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
    }

    public Artiste() {

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
        return new AlbumImpl().getArtisteAlbums(this.getNom());
    }

    public void print() {
        System.out.println(this.getNom() + " - " + this.getNationalite());
    }
}
