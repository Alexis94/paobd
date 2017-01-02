package views;

import dao.impl.AlbumImpl;
import dao.models.Album;
import dao.models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeAlbumsView {
    public ListeAlbumsView(Scanner in, User user) {
        int i = 0;
        for (Album album : user.getAlbums()) {
            System.out.print(++i + ". ");
            album.print();
        }
        System.out.println("\n1. Voir un album");
        System.out.println("2. Ajouter un album de la collection");
        System.out.println("3. Retirer un album de la collection");
        System.out.println("4. Retourner au profil");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4) {
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            nomAlbum = in.nextLine();
            MainFrameController.showAlbumView(new AlbumImpl().getAlbum(nomAlbum));
        } else if (n == 2) {
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            nomAlbum = in.nextLine();
            if (new AlbumImpl().ajouterAlbumUser(MainFrameController.user.getPseudo(), nomAlbum)) {
                MainFrameController.user.ajouterAlbum(new AlbumImpl().getAlbum(nomAlbum));
                MainFrameController.showListeAlbumsView(MainFrameController.user);
            }
        } else if (n == 3) {
            System.out.print("Numéro de l'album: ");
            int numeroAlbum = in.nextInt();
            if (new AlbumImpl().retirerAlbumUser(user.getPseudo(), user.getAlbums().get(numeroAlbum - 1).getNom())) {
                user.retirerAlbum(user.getAlbums().get(numeroAlbum - 1));
                MainFrameController.showListeAlbumsView(user);
            } else {
                System.out.println("Erreur lors de la suppression de l'album de la bibliothèque personnelle");
            }
        } else {
            MainFrameController.showProfil();
        }
    }

    public ListeAlbumsView(Scanner in, ArrayList<Album> albums) {
        for (Album album : albums) {
            album.print();
        }
        System.out.println("\n1. Voir un album");
        System.out.println("2. Ajouter un album à la collection");
        System.out.println("3. Retourner au profil");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3) {
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            nomAlbum = in.nextLine();
            MainFrameController.showAlbumView(new AlbumImpl().getAlbum(nomAlbum));
        } else if (n == 2) {
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            nomAlbum = in.nextLine();
            if (new AlbumImpl().ajouterAlbumUser(MainFrameController.user.getPseudo(), nomAlbum)) {
                MainFrameController.user.ajouterAlbum(new AlbumImpl().getAlbum(nomAlbum));
                MainFrameController.showListeAlbumsView(MainFrameController.user);
            }
        } else {
            MainFrameController.showProfil();
        }
    }

    //TODO refactorer en ajoutant méthode pour regrouper deux constructeurs voir pareil pour chaque view (voir listeArtistesView)
}
