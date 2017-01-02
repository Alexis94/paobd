package dao.models;

import dao.impl.PlaylistImpl;

import java.util.ArrayList;

import static utils.Utils.formatDuree;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Playlist {
    private int id;
    private String nom;
    private Integer duree;
    private String pseudoUser;

    public Playlist(int id, String nom, String pseudoUser) {
        this.id = id;
        this.nom = nom;
        this.pseudoUser = pseudoUser;
        this.duree = 0;
    }

    public Playlist() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public ArrayList<Titre> getTitres() {
        return new PlaylistImpl().getPlaylistTitres(this.getId());
    }


    public void print() {
        System.out.println(this.getNom() + " - " + formatDuree(this.getDuree()));
    }

    public boolean ajouterTitre(Titre nouveauTitre) {
        this.setDuree(this.getDuree() + nouveauTitre.getDuree());
        return new PlaylistImpl().ajouterTitre(getId(), nouveauTitre.getId());
    }

    public boolean supprimerTitre(Titre titre) {
        this.setDuree(this.getDuree() - titre.getDuree());
        return new PlaylistImpl().retirerTitre(getId(), titre.getId());
    }

}
