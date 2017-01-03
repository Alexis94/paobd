package views;

import dao.impl.EcouteImpl;
import dao.impl.TitreImpl;
import dao.models.Playlist;
import dao.models.Titre;
import dao.models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexis on 03/12/2016.
 */
public class ListeTitresView {
    public ListeTitresView(Scanner in, User user) {
        //TODO Sort titres
        int i = 0;
        for (Titre titre : user.getTitres()) {
            System.out.print(++i + ".");
            titre.print();
        }

        System.out.println("1. Ajouter titre");
        System.out.println("2. Retirer titre");
        System.out.println("3. Ajouter titre à une playlist");
        System.out.println("4. Ajouter titre à la liste d'écoute");
        System.out.println("5. Retourner au profil");
        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4 && n != 5) {
            n = in.nextInt();
        }

        if (n == 1) {
            MainFrameController.showAjouterTitreView(0);
        } else if (n == 2) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            if (new TitreImpl().retirerTitreUser(user.getPseudo(), user.getTitres().get(titreId - 1).getId())) {
                user.retirerTitre(user.getTitres().get(titreId - 1));
                MainFrameController.showListeTitresView();
            } else {
                System.out.println("Erreur lors de la suppression du titre de la bibliothèque personnelle");
            }
        } else if (n == 3) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            System.out.println("Playlists:");
            int j = 0;
            for (Playlist playlist : user.getPlaylists()) {
                System.out.print(++j + ". ");
                playlist.print();
            }
            System.out.print("Numéro de la playlist: ");
            int numeroPlaylist = in.nextInt();
            user.getPlaylists().get(numeroPlaylist - 1).ajouterTitre(new TitreImpl().getTitre(String.valueOf(titreId)));
            MainFrameController.showPlaylistView(user.getPlaylists().get(numeroPlaylist - 1));

        } else if (n == 4) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            new EcouteImpl().ajouterEcoute(user.getPseudo(), user.getTitres().get(titreId - 1).getId());
            MainFrameController.showEcoutesView();
        } else {
            MainFrameController.showProfil();
        }


    }

    public ListeTitresView(Scanner in, ArrayList<Titre> titres) {
        User user = MainFrameController.user;
        for (Titre titre : titres) {
            titre.printWithId();
        }
        System.out.println("\n1. Ajouter titre à la collection");
        System.out.println("2. Ajouter titre à une Playlist");
        System.out.println("3. Ajouter titre à la liste d'écoute");
        System.out.println("4. Retourner au profil\n");

        int n = in.nextInt();

        while (n != 1 && n != 2 && n != 3 && n != 4) {
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            if (new TitreImpl().retirerTitreUser(user.getPseudo(), user.getTitres().get(titreId - 1).getId())) {
                user.retirerTitre(user.getTitres().get(titreId - 1));
                MainFrameController.showListeTitresView();
            } else {
                System.out.println("Erreur lors de la suppression du titre de la bibliothèque personnelle");
            }
        } else if (n == 2) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            System.out.println("Playlists:");
            int j = 0;
            for (Playlist playlist : user.getPlaylists()) {
                System.out.print(++j + ". ");
                playlist.print();
            }
            System.out.print("Numéro de la playlist: ");
            int numeroPlaylist = in.nextInt();
            user.getPlaylists().get(numeroPlaylist - 1).ajouterTitre(new TitreImpl().getTitre(String.valueOf(titreId)));
            MainFrameController.showPlaylistView(user.getPlaylists().get(numeroPlaylist - 1));
        } else if (n == 3) {
            System.out.print("ID du titre: ");
            int titreId = in.nextInt();
            new EcouteImpl().ajouterEcoute(user.getPseudo(), titreId);
            MainFrameController.showEcoutesView();
        } else {
            MainFrameController.showProfil();
        }

    }
}
