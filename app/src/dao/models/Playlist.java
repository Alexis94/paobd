package dao.models;

import dao.impl.PlaylistImpl;

import java.util.ArrayList;

import static utils.Utils.formatDuree;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Playlist {
    String id;
    String nom;
    Integer duree;
    String pseudoUser;

    public Playlist(String id, String nom, ArrayList<Titre> titres, String pseudoUser) {
        this.id = id;
        this.nom = nom;
        this.pseudoUser = pseudoUser;
        this.duree = 0;
    }

    public Playlist() {

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
        return new PlaylistImpl().getPlaylistTitres(this.getId());
    }


    public void print() {
        System.out.println(this.getId() + " - " + this.getNom() + " - " + formatDuree(this.getDuree()));
    }

}
