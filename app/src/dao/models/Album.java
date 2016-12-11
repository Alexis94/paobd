package dao.models;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Album {
    String nom;
    int annee;
    Artiste artiste;
    ArrayList<Titre> titres;
    int duree;

    public Album(String nom, int annee, Artiste artiste, ArrayList<Titre> titres) {
        this.nom = nom;
        this.annee = annee;
        this.artiste = artiste;
        this.titres = titres;
        this.duree = 0;

        for (Titre titre : this.titres){
            this.duree += titre.getDuree();
        }
    }

    public Album() {
        this.titres = new ArrayList<Titre>();
    }

    public Album(String nomAlbum) {
        this.titres = new ArrayList<Titre>();
        this.nom = nomAlbum;
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

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public ArrayList<Titre> getTitres() {
        return titres;
    }

    public void ajouterTitre(Titre titre) {
        this.titres.add(titre);
    }

    public void retirerTitre(Titre titre) {
        this.titres.remove(titre);
    }

    public int getDuree() {
        return duree;
    }

    //TODO getFormattedDuree()

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void print() {
        System.out.println(this.getNom() + " - " + this.getArtiste().getNom() + " - " + this.getDuree()/60 + ":" + this.getDuree()%60);
    }
}
