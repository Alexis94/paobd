package views;

import dao.impl.AlbumImpl;
import dao.impl.ArtisteImpl;
import dao.impl.TitreImpl;
import sun.applet.Main;
import utils.GenreMusique;

import java.util.Scanner;

/**
 * Created by Alexis on 17/12/2016.
 */
public class AjouterTitreView {
    public AjouterTitreView(Scanner in) {
        System.out.println("1. Ajouter titre depuis la collection");
        System.out.println("2. Créer titre à ajouter");
        System.out.println("3. Retourner au profil");


        int n = in.nextInt();

        while(n != 1 && n != 2 && n != 3){
            n = in.nextInt();
        }

        if (n == 1) {
            System.out.println("Indiquez les ids des titres que vous voulez ajouter séparés d'un espace.");
            String titresIds = in.nextLine();
            titresIds = in.nextLine();
            MainFrameController.user.ajouterTitres(titresIds.split(" "));
            MainFrameController.showProfil();
        } else if (n == 2) {
            System.out.println("---- ARTISTE ----");
            System.out.print("Nom artiste: ");
            String nomArtiste = in.nextLine();
            nomArtiste = in.nextLine();
            if (!new ArtisteImpl().artisteExiste(nomArtiste)) {
                System.out.print("Nationalité de l'artiste: ");
                String nationaliteArtiste = in.nextLine();
                new ArtisteImpl().creerArtiste(nomArtiste, nationaliteArtiste);
            }
            System.out.println("---- ALBUM ----");
            System.out.print("Nom de l'album: ");
            String nomAlbum = in.nextLine();
            if (!new AlbumImpl().albumExiste(nomAlbum)) {
                System.out.print("Année de l'album:");
                int annee = in.nextInt();
                new AlbumImpl().creerAlbum(nomAlbum, nomArtiste, annee);
            }
            System.out.println("---- TITRE ----");
            System.out.print("Nom: ");
            String nomTitre = in.nextLine();
            nomTitre = in.nextLine();
            System.out.print("Durée: ");
            int duree = in.nextInt();
            GenreMusique.print();
            int choix = in.nextInt();
            while (!(choix > 0 && choix <= 7 )) {
                choix = in.nextInt();
            }
            TitreImpl titreImpl = new TitreImpl();

            titreImpl.creerTitre(nomTitre, duree, nomArtiste, nomAlbum, GenreMusique.get(choix));
            MainFrameController.user.ajouterTitre(titreImpl.getTitre(String.valueOf(titreImpl.getDernierId())));
            MainFrameController.showListeTitresView();

        } else if (n == 3) {
            MainFrameController.showProfil();
        }
    }
}
