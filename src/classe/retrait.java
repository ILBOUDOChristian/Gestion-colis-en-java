/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import static gestioncolis.formmenu.*;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ILBOUDO Christian
 */
public class retrait {
    public retrait(){ 
    }
    
    
    
    
    public static void actualiser(DefaultTableModel tm) {
    try {
        c = connectionbd.seconnecter();
        st = c.createStatement();
        String query = "SELECT toutcolis.identifiant, retrait.dateretrait, toutcolis.expediteur, toutcolis.recepteur, toutcolis.nbpaquet, toutcolis.type, toutcolis.arrivee, toutcolis.telrecepteur " +
                       "FROM toutcolis " +
                       "INNER JOIN retrait ON toutcolis.identifiant = retrait.identifiant " +
                       "ORDER BY toutcolis.identifiant";
        rs = st.executeQuery(query);
        while (rs.next()) {
            // Ajouter une nouvelle ligne avec tous les éléments récupérés de la base de données
            tm.addRow(new Object[]{
                rs.getString("dateretrait"),
                rs.getString("identifiant"),
                rs.getString("expediteur"),
                rs.getString("recepteur"),
                rs.getString("nbpaquet"),
                rs.getString("type"),
                rs.getString("arrivee"), 
                rs.getString("telrecepteur")
            });
        }
        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(retrait.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erreur lors de l'actualisation des données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    } 
    
 
    public static void modifier(String dateRetrait , String identifiant, String expediteur, String recepteur, String nombrePaquets, String type, String villeArrive, String telRecepteur) throws FileNotFoundException {
    try {
        // Connexion à la base de données
        c = connectionbd.seconnecter();
        st = c.createStatement();
        
        // Vérification si le colis existe dans la table `toutcolis`
        String query = "SELECT * FROM toutcolis WHERE identifiant = '" + identifiant + "'";
        rs = st.executeQuery(query);

        if (rs.next()) {
            // Mise à jour des champs dans la table `retrait`
            String queryUpdateRetrait = "UPDATE retrait SET dateretrait=?, expediteur=?, recepteur=?, nbpaquet=?, type=?, arrivee=?, telrecepteur=? WHERE identifiant=?";
            ps = c.prepareStatement(queryUpdateRetrait);
            ps.setString(1, dateRetrait);
            ps.setString(2, expediteur);
            ps.setString(3, recepteur);
            ps.setString(4, nombrePaquets);
            ps.setString(5, type);
            ps.setString(6, villeArrive);
            ps.setString(7, telRecepteur);
            ps.setString(8, identifiant);
            ps.executeUpdate();

        
           JOptionPane.showMessageDialog(null, "Les informations de " + expediteur + " ont été mises à jour avec succès");
        } else {
            JOptionPane.showMessageDialog(null, "Aucun enregistrement trouvé pour l'identifiant: " + identifiant);
        }

        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
        Logger.getLogger(retrait.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    

    
}
    

