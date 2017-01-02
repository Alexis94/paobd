package dao;

import dao.models.User;

/**
 * Created by Alexis on 13/11/2016.
 */
public interface UserDAO {
    boolean ajouterUser(User user);

    User seConnecter(String pseudo, String password);
}
