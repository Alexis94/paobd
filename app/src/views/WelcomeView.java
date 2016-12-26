package views;

import java.util.Scanner;

/**
 * Created by Alexis on 21/11/2016.
 */
public class WelcomeView {
    public WelcomeView(Scanner in){


        System.out.println("------------------------------------------");
        System.out.println("| Bienvenue dans votre librarie Musicale |");
        System.out.println("1. Se Connecter");
        System.out.println("2. Créer un compte\n");
        int n = in.nextInt();

        while(n != 1 && n != 2){
            n = in.nextInt();
        }

        if (n == 1){
            MainFrameController.showSeConnecterView();
        } else {
            MainFrameController.showCreerCompteView();
        }
    }
}
