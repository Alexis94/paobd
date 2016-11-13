package dao.models;

import java.util.Date;

/**
 * Created by Alexis on 13/11/2016.
 */
public class Ecoute {
    Date dateEcoute;
    Titre Titre;

    public Ecoute(Date dateEcoute, dao.models.Titre titre) {
        this.dateEcoute = dateEcoute;
        Titre = titre;
    }

    public Date getDateEcoute() {
        return dateEcoute;
    }

    public void setDateEcoute(Date dateEcoute) {
        this.dateEcoute = dateEcoute;
    }

    public dao.models.Titre getTitre() {
        return Titre;
    }

    public void setTitre(dao.models.Titre titre) {
        Titre = titre;
    }
}
