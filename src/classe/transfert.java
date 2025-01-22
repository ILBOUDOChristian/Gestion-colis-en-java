/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import static gestioncolis.formmenu.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ILBOUDO Christian
 */
public class transfert {
    public transfert (){
    }

 public static void actualiser(DefaultTableModel tm) {
    try {
        c = connectionbd.seconnecter();
        st = c.createStatement();
        rs = st.executeQuery("SELECT * FROM toutcolis ORDER BY identifiant");
        while (rs.next()) {
            // Ajouter une nouvelle ligne avec tous les éléments récupérés de la base de données
            tm.addRow(new Object[]{
                rs.getString("date"),
                rs.getString("identifiant"),
                rs.getString("nbpaquet"),
                rs.getString("prix"),
                rs.getString("expediteur"),
                rs.getString("depart"),
                rs.getString("type"),
                rs.getString("tel")
                
            });
        }
        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(transfert.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
 
 
 public static void modifier(String date, String identifiant, String nombre_paquets, String prix,
                                     String expediteur, String depart, String type, String tel) {
    try {
        c = connectionbd.seconnecter();
        st = c.createStatement();
        // Vérifier si l'enregistrement avec l'identifiant spécifié existe
        rs = st.executeQuery("SELECT * FROM toutcolis WHERE identifiant ='" + identifiant + "'");
        if (rs.next()) {
            ps = c.prepareStatement("UPDATE toutcolis SET date=?, nbpaquet=?, prix=?, expediteur=?, depart=?, type=?, tel=? WHERE identifiant=?");
            // Mise à jour des champs
            ps.setString(1, date);
            ps.setString(2, nombre_paquets);
            ps.setString(3, prix);
            ps.setString(4, expediteur);
            ps.setString(5, depart);
            ps.setString(6, type);
            ps.setString(7, tel);
            ps.setString(8, identifiant);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Les informations de " + expediteur + " ont été mises à jour avec succès");
        } 
        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
        Logger.getLogger(transfert.class.getName()).log(Level.SEVERE, null, ex);
    }
}



}
