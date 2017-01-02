package dao.models;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Ecoute {
    private String dateEcoute;
    private Titre Titre;

    public Ecoute(String dateEcoute, Titre titre) {
        this.dateEcoute = dateEcoute;
        Titre = titre;
    }

    public Ecoute() {

    }

    public String getDateEcoute() {
        return dateEcoute;
    }

    public void setDateEcoute(String dateEcoute) {
        this.dateEcoute = dateEcoute;
    }

    public Titre getTitre() {
        return Titre;
    }

    public void setTitre(dao.models.Titre titre) {
        Titre = titre;
    }

    public void print() {
        System.out.print(this.getDateEcoute() + " -- ");
        this.getTitre().print();
    }
}
