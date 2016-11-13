package dao.models;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Playlist {
    String id;
    String nom;
    ArrayList<Titre> titres;
    Integer duree;
    String pseudoUser;

    public Playlist(String id, String nom, ArrayList<Titre> titres, String pseudoUser) {
        this.id = id;
        this.nom = nom;
        this.titres = titres;
        this.pseudoUser = pseudoUser;
        this.duree = 0;
        for (Titre titre : this.titres) {
            this.duree += titre.getDuree();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getPseudouser() {
        return pseudoUser;
    }

    public void setPseudoUser(String pseudoUser) {
        this.pseudoUser = pseudoUser;
    }

    public ArrayList<Titre> getTitres(){
        return titres;
    }

    public void ajouterTitre(Titre titre) {
        this.titres.add(titre);
    }

    public  void retirerTitre(Titre titre) {
        this.titres.remove(titre);
    }
}
