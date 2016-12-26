package dao.models;

import dao.impl.TitreImpl;

import java.util.ArrayList;

import static utils.Utils.formatDuree;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Album {
    String nom;
    int annee;
    String artiste;
    int duree;

    public Album(String nom, int annee, String artiste) {
        this.nom = nom;
        this.annee = annee;
        this.artiste = artiste;
        this.duree = 0;

    }

    public Album(String nom) {
        this.nom = nom;
    }

    public Album() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public ArrayList<Titre> getTitres() {
        return new TitreImpl().getAlbumTitres(this.nom);
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void print() {
        System.out.println(this.getNom() + " - " + this.getArtiste() + " - " + formatDuree(this.getDuree()));
    }
}
