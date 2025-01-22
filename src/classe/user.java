/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import static gestioncolis.formmenu.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class user {
    private String username;
    private String password;

    // Constructeur par défaut
    public user() {
    }
 public user(String username, String password) {
        this.username = username;
        this.password = password;
    }


    // Méthode statique pour vérifier les identifiants
    public static boolean connexion(String pseudo, String password) {
        cs = null;
        ps = null;
         rs = null;

        try {
            cs = connectionbd.seconnecter();
            String sql = "SELECT * FROM users WHERE pseudo = ? AND pass = ?";
            ps = cs.prepareStatement(sql);
            ps.setString(1, pseudo);
            ps.setString(2, password);
            rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cs != null) cs.close();
            } catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Méthode pour vérifier si l'utilisateur est valide
    public boolean isValidUser() {
        return user.connexion(this.username, this.password);
    }
}
