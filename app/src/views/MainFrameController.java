package views;

import dao.models.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 21/11/2016.
 */
public class MainFrameController {
    static User user;
    static Scanner in;

    /*static JFrame frame;

    public MainFrameController() {
        frame = new JFrame();
        frame.setTitle("Librairie Musicale");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void setView(WelcomeView view) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(view);
    }

    public static void setView(SeConnecterView view) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(view);
    }

    public static void setView(CreerCompteView view) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(view);
    }*/
    public MainFrameController() {
        user = new User();
        in = new Scanner(System.in);  // Reading from System.in
        showWelcomeView();
    }

    public static void showWelcomeView() {
        //clearScreen();
        new WelcomeView(in);
    }

    public static void showSeConnecterView() {
        //clearScreen();
        new SeConnecterView(in);
    }

    public static void showCreerCompteView() {
        clearScreen();
        new CreerCompteView(in);
    }

    public static void showProfil() {
        clearScreen();
        new ProfilView(user, in);
    }

    public static void showListeTitresView() {
        clearScreen();
        new ListeTitresView(in, user);
    }

    public static void showListeArtistesView() {
        clearScreen();
        new ListeArtistesView(in, user);
    }

    public static void showListeAlbumsView(User user) {
        clearScreen();
        new ListeAlbumsView(in, user);
    }

    public static void showAlbumView(Album album) {
        clearScreen();
        new AlbumView(in, album);
    }

    public static void setUser(User user) {
        MainFrameController.user = user;
    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void showArtisteView(Artiste artiste) {
        clearScreen();
        new ArtisteView(in, artiste);
    }

    public static void showRechercherView() {
        clearScreen();
        new RechercherView(in);
    }

    public static void showListeTitresView(ArrayList<Titre> titres) {
        clearScreen();
        new ListeTitresView(in, titres);
    }

    public static void showListeAlbumsView(ArrayList<Album> albums) {
        clearScreen();
        new ListeAlbumsView(in, albums);
    }

    public static void showListeArtistesView(ArrayList<Artiste> artistes) {
        clearScreen();
        new ListeArtistesView(in, artistes);
    }

    public static void showListePlaylistsView() {
        clearScreen();
        new ListePlaylistsView(in, user);
    }

    public static void showPlaylistView(Playlist playlist) {
        clearScreen();
        new PlaylistView(in, playlist);
    }

    public static void showAjouterTitreView(int playlistId) {
        clearScreen();
        new AjouterTitreView(in, playlistId);
    }

    public static void showEcoutesView() {
        clearScreen();
        new EcouteView(in);

    }
}
