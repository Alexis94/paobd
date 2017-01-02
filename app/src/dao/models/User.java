package dao.models;

import dao.impl.EcouteImpl;
import dao.impl.TitreImpl;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */

public class User {
    private String pseudo;
    private String nom;
    private String prenom;
    private String password;
    private int age;
    private ArrayList<Titre> titres;
    private ArrayList<Album> albums;
    private ArrayList<Artiste> artistes;
    private ArrayList<Playlist> playlists;
    private ArrayList<Ecoute> ecoutes;

    public User(String pseudo, String nom, String prenom, int age, ArrayList<Titre> titres, ArrayList<Album> albums, ArrayList<Artiste> artistes, ArrayList<Playlist> playlists, ArrayList<Ecoute> ecoutes) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.titres = titres;
        this.albums = albums;
        this.artistes = artistes;
        this.playlists = playlists;
        this.ecoutes = ecoutes;
    }

    public User() {
        this.titres = new ArrayList<Titre>();
        this.albums = new ArrayList<Album>();
        this.artistes = new ArrayList<Artiste>();
        this.playlists = new ArrayList<Playlist>();
        this.ecoutes = new ArrayList<Ecoute>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Titre> getTitres() {
        return titres;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Artiste> getArtistes() {
        return artistes;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public ArrayList<Ecoute> getEcoutes() {
        return new EcouteImpl().getUserEcoute(this.getPseudo());
    }

    public void ajouterTitre(Titre titre) {
        this.titres.add(titre);
    }

    public void retirerTitre(Titre titre) {
        this.titres.remove(titre);
    }

    public void ajouterArtiste(Artiste artiste) {
        this.artistes.add(artiste);
    }

    public void retirerArtiste(Artiste artiste) {
        this.artistes.remove(artiste);
    }

    public void ajouterAlbum(Album album) {
        this.albums.add(album);
    }

    public void retirerAlbum(Album album) {
        this.albums.remove(album);
    }

    public void ajouterEcoute(Ecoute ecoute) {
        this.ecoutes.add(ecoute);
    }

    public void retirerEcoute(Ecoute ecoute) {
        this.ecoutes.remove(ecoute);
    }

    public void ajouterPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void retirerPlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    public void print() {
        System.out.println("Pseudo -- Nom -- Prénom -- Age");
        System.out.println(this.pseudo + " -- " + this.nom + " -- " + this.prenom + " -- " + this.age);
    }

    public void ajouterTitres(String[] titresIds) {
        TitreImpl titreImpl = new TitreImpl();
        for (String titreId : titresIds) {
            titreImpl.ajouterTitreUser(getPseudo(), titreId);
            this.ajouterTitre(titreImpl.getTitre(titreId));
        }
    }
}

