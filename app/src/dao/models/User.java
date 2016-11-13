package dao.models;

import java.util.ArrayList;

/**
 * Created by Alexis on 13/11/2016.
 */

public class User {
    String pseudo;
    String nom;
    String prenom;
    int age;
    ArrayList<Titre> titres;
    ArrayList<Album> albums;
    ArrayList<Artiste> artistes;
    ArrayList<Playlist> playlists;
    ArrayList<Ecoute> ecoutes;

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

    public String getPseudo() {
        return pseudo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
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
        return ecoutes;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void retirerArtiste(Artiste artiste){
        this.artistes.remove(artiste);
    }

    public void ajouterAlbum(Album album) {
        this.albums.add(album);
    }

    public  void retirerAlbum(Album album) {
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
}
