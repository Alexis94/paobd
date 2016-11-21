package dao.impl;

import dao.DatabaseConnection;
import dao.UserDAO;
import dao.models.User;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Created by Alexis on 13/11/2016.
 */
public class UserImpl implements UserDAO {
    String table = "utilisateur";
    @Override
    public boolean ajouterUser(User user){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(user.getPassword().getBytes("UTF-8"));
            byte[] digest = md.digest();
            String hashedPassword = new String(digest, StandardCharsets.UTF_8);
            String values = user.getPseudo() + ", " + hashedPassword + ", " + user.getNom() + ", " + user.getPrenom() + ", " + Integer.toString(user.getAge());
            return DatabaseConnection.insert(values, this.table);
        } catch (NoSuchAlgorithmException | SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerUser(String pseudo) {
        return false;
    }
}
