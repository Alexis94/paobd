package utils;

import java.util.Scanner;

/**
 * Created by Alexis on 13/11/2016.
 */
public enum GenreMusique {
    POP, ROCK, JAZZ, BLUES, ELECTRONIQUE, VARIETE, RAP, REGGAE;

    public static void print() {
        System.out.println("1. POP");
        System.out.println("2. ROCK");
        System.out.println("3. JAZZ");
        System.out.println("4. BLUES");
        System.out.println("5. ELECTRONIQUE");
        System.out.println("6. VARIETE");
        System.out.println("7. RAP");
        System.out.println("8. REGGAE");
    }

    public static String get(int choix) {
        switch (choix) {
            case 1:
                return "POP";
            case 2:
                return "ROCK";
            case 3:
                return "JAZZ";
            case 4:
                return "BLUES";
            case 5:
                return "ELECTRONIQUE";
            case 6:
                return "VARIETE";
            case 7:
                return "RAP";
            case 8:
                return "REGGAE";
            default:
                return "";
        }
    }
}
