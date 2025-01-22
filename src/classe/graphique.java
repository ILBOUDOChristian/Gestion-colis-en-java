/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import static gestioncolis.formmenu.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ILBOUDO Christian
 */
public class graphique {

    
    public graphique(){
    }

public static void Statistiques() {
        // Déclaration des maps pour les statistiques
        
        Map<String, Integer> colisParMois = new HashMap<>();
        Map<String, Integer> colisParAn = new HashMap<>();
        Map<String, Double> chiffreAffairesParMois = new HashMap<>();
        Map<String, Double> chiffreAffairesParAn = new HashMap<>();

        try {
            // Connexion à la base de données
            c = connectionbd.seconnecter();
            st = c.createStatement();
            rs = st.executeQuery("SELECT date, nbpaquet, prix FROM toutcolis");

            while (rs.next()) {
                // Extraction des données de la base de données
                String date = rs.getString("date");
                String moisAn = date.substring(0, 7); // yyyy-MM
                String an = date.substring(0, 4); // yyyy
                int nbPaquet = Integer.parseInt(rs.getString("nbpaquet"));
                double prix = Double.parseDouble(rs.getString("prix"));

                // Comptage des colis par mois
                colisParMois.put(moisAn, colisParMois.getOrDefault(moisAn, 0) + nbPaquet);

                // Comptage des colis par année
                colisParAn.put(an, colisParAn.getOrDefault(an, 0) + nbPaquet);

                // Comptage du chiffre d'affaires par mois
                chiffreAffairesParMois.put(moisAn, chiffreAffairesParMois.getOrDefault(moisAn, 0.0) + prix);

                // Comptage du chiffre d'affaires par année
                chiffreAffairesParAn.put(an, chiffreAffairesParAn.getOrDefault(an, 0.0) + prix);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(graphique.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                Logger.getLogger(graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }

    
    
   

    
    }
