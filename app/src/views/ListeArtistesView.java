package views;

import dao.impl.AlbumImpl;
import dao.impl.ArtisteImpl;
import dao.models.Artiste;
import dao.models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeArtistesView {
    public ListeArtistesView(Scanner in, User user){
        afficherVue(in, user.getArtistes());
        System.out.println("\n1. Voir un artiste");
        System.out.println("2. Ajouter un artiste à la collection");
        System.out.println("3. Retirer un artiste de la collection");
        System.out.println("4. Retourner au profil");

        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3 && n != 4){
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Nom de l'artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            MainFrameController.showArtisteView(new ArtisteImpl().getArtiste(nomArtiste));
        } else if (n == 2) {
            System.out.print("Nom de l'artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            if (new ArtisteImpl().ajouterArtisteUser(MainFrameController.user.getPseudo(), nomArtiste)) {
                MainFrameController.user.ajouterArtiste(new ArtisteImpl().getArtiste(nomArtiste));
                MainFrameController.showListeArtistesView();
            }
        } else if (n == 3) {
            System.out.print("Numéro de l'artiste: ");
            int numeroArtiste = in.nextInt();
            if (new ArtisteImpl().retirerArtisteUser(user.getPseudo(), user.getArtistes().get(numeroArtiste-1).getNom())) {
                user.retirerArtiste(user.getArtistes().get(numeroArtiste-1));
                MainFrameController.showListeArtistesView();
            } else {
                System.out.println("Erreur lors de la suppression de l'album de la bibliothèque personnelle");
            }
        } else {
            MainFrameController.showProfil();
        }
    }

    public ListeArtistesView(Scanner in, ArrayList<Artiste> artistes) {
        afficherVue(in, artistes);
        System.out.println("\n1. Voir un artiste");
        System.out.println("2. Ajouter un artiste à la collection");
        System.out.println("3. Retourner au profil");

        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3){
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("Nom de l'artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            MainFrameController.showArtisteView(new ArtisteImpl().getArtiste(nomArtiste));
        } else if (n == 2) {
            System.out.print("Nom de l'artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            if (new ArtisteImpl().ajouterArtisteUser(MainFrameController.user.getPseudo(), nomArtiste)) {
                MainFrameController.user.ajouterArtiste(new ArtisteImpl().getArtiste(nomArtiste));
                MainFrameController.showListeArtistesView();
            }
        } else {
            MainFrameController.showProfil();
        }
    }

    private void afficherVue(Scanner in, ArrayList<Artiste> artistes) {
        int i = 0;
        for (Artiste artiste : artistes) {
            System.out.print(++i + ". ");
            artiste.print();
        }
    }
}
