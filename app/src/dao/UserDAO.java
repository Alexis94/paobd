package dao;

import dao.models.User;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface UserDAO {
    public boolean ajouterUser(User user);
    public boolean supprimerUser(String pseudo);
}
