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
public class toutcolis {
    public toutcolis(){ 
    }

public static void valider(String date , String identifiant  ,String nombre_paquets ,String type,String poids,String prix,
            String expediteur,String cni ,String villedepart ,String tel,String recepteur, String villearrive,String telrecepteur) throws FileNotFoundException{
        try {
             c=connectionbd.seconnecter();
             st=c.createStatement();
             //verifier si le id  n'est pas enregistre
             rs=st.executeQuery("SELECT * FROM toutcolis WHERE cni ='"+cni+"'");
               if(!rs.next()){
                   ps=c.prepareStatement("INSERT INTO toutcolis(date,identifiant ,nbpaquet,type,poids,prix,expediteur,cni,depart,tel,recepteur,arrivee,telrecepteur ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)") ;
                   //enregistrement
                   ps.setString(1, date );
                   ps.setString(2, identifiant);
                    ps.setString(3, nombre_paquets);
                      ps.setString(4, type);
                       ps.setString(5, poids);
                       ps.setString(6, prix);
                        ps.setString(7, expediteur);
                         ps.setString(8, cni);
                          ps.setString(9, villedepart);
                           ps.setString(10, tel);
                            ps.setString(11,recepteur);
                             ps.setString(12, villearrive);
                              ps.setString(13, telrecepteur);
                          
                          ps.execute();
                   JOptionPane.showMessageDialog(null, expediteur+" a été enregistré avec succès");
               }
               else{
                   JOptionPane.showMessageDialog(null, identifiant+" est déjà enregistré");
               }
               c.close();
               st.close();
               rs.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(toutcolis.class.getName()).log(Level.SEVERE, null, ex);
        } 
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
                rs.getString("type"),
                rs.getString("poids"),
                rs.getString("prix"),
                rs.getString("expediteur"),
                rs.getString("cni"),
                rs.getString("depart"),
                rs.getString("tel"),
                rs.getString("recepteur"),
                rs.getString("arrivee"),
                rs.getString("telrecepteur")
            });
        }
        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(toutcolis.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

public static void modifier(String date, String identifiant, String nombre_paquets, String type, String poids, String prix,
                            String expediteur, String cni, String villedepart, String tel, String recepteur, String villearrive,
                            String telrecepteur) throws FileNotFoundException {
    try {
        c = connectionbd.seconnecter();
        st = c.createStatement();
        // Vérifier si l'enregistrement avec le cni spécifié existe
        rs = st.executeQuery("SELECT * FROM toutcolis WHERE cni ='" + cni + "'");
        if (rs.next()) {
            ps = c.prepareStatement("UPDATE toutcolis SET date=?, identifiant=?, nbpaquet=?, type=?, poids=?, prix=?, expediteur=?, depart=?, tel=?, recepteur=?, arrivee=?, telrecepteur=? WHERE cni=?");
            // Mise à jour des champs
            ps.setString(1, date);
            ps.setString(2, identifiant);
            ps.setString(3, nombre_paquets);
            ps.setString(4, type);
            ps.setString(5, poids);
            ps.setString(6, prix);
            ps.setString(7, expediteur);
            ps.setString(8, villedepart);
            ps.setString(9, tel);
            ps.setString(10, recepteur);
            ps.setString(11, villearrive);
            ps.setString(12, telrecepteur);
            ps.setString(13, cni);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Les informations de " + expediteur + " ont été mises à jour avec succès");
        } else {
            JOptionPane.showMessageDialog(null, "Aucun enregistrement trouvé pour le cni: " + cni);
        }
        // Fermer les ressources
        rs.close();
        st.close();
        c.close();
    } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
        Logger.getLogger(toutcolis.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static void rechercher(DefaultTableModel tm, String expediteur) throws SQLException {
    c = null;
     p = null;
    rs = null;

    try {
        c = connectionbd.seconnecter();
        p = c.prepareStatement("SELECT * FROM toutcolis WHERE expediteur LIKE ? ORDER BY expediteur");

        String searchPattern = "%" + expediteur + "%";
        p.setString(1, searchPattern);

        rs = p.executeQuery();

        // Clear existing rows
        while (tm.getRowCount() > 0) {
            tm.removeRow(0);
        }

        int n = 0;
        while (rs.next()) {
            n++;
            tm.addRow(new Object[]{
                rs.getString("date"),
                rs.getString("identifiant"),
                rs.getString("nbpaquet"),
                rs.getString("type"),
                rs.getString("poids"),
                rs.getString("expediteur"),
                rs.getString("cni"),
                rs.getString("depart"),
                rs.getString("tel"),
                rs.getString("recepteur"),
                rs.getString("arrivee"),
                rs.getString("telrecepteur")
            });
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(toutcolis.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (rs != null) rs.close();
        if (p != null) p.close();
        if (c != null) c.close();
    }
}

}


