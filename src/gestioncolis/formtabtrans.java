/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncolis;



import classe.exportercolis;
import classe.toutcolis;
import java.awt.Desktop;
import java.io.File;

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
public class formtabtrans extends javax.swing.JPanel {

    
    
    public formtabtrans() {
        initComponents();
       
    DefaultTableModel t=(DefaultTableModel) tabtrans.getModel();
         t.setRowCount(0);
         classe.transfert.actualiser(t); 
         
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnmodifier = new javax.swing.JButton();
        btnexporter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabtrans = new javax.swing.JTable();
        txtrecherche = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(230, 231, 232));

        btnmodifier.setBackground(new java.awt.Color(255, 51, 51));
        btnmodifier.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnmodifier.setForeground(new java.awt.Color(255, 255, 255));
        btnmodifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modifier_32.png"))); // NOI18N
        btnmodifier.setText("MODIFIER");
        btnmodifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });

        btnexporter.setBackground(new java.awt.Color(51, 51, 255));
        btnexporter.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnexporter.setForeground(new java.awt.Color(255, 255, 255));
        btnexporter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel_32.png"))); // NOI18N
        btnexporter.setText("EXPORTER");
        btnexporter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexporterActionPerformed(evt);
            }
        });

        tabtrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Id", "N°paquets", "Prix", "Expediteur", "Ville D", "Type", "Tel exp"
            }
        ));
        tabtrans.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabtrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabtransMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabtrans);

        txtrecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrechercheKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewmag--icone-5948-32.png"))); // NOI18N
        jLabel2.setText("RECHERCHE ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(btnmodifier)
                .addGap(18, 18, 18)
                .addComponent(btnexporter)
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodifier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexporter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed

        DefaultTableModel t = (DefaultTableModel) tabtrans.getModel();
        int selectedRowIndex = tabtrans.getSelectedRow();

        if (selectedRowIndex >= 0) {
            String[] columnNames = {"Date", "Identifiant", "Nombre de Paquets", "Type", "Poids", "Prix", "Expéditeur", "CNI", "Ville de Départ", "Téléphone", "Récepteur", "Ville d'Arrivée", "Téléphone Récepteur"};
            String selectedColumn = (String) JOptionPane.showInputDialog(null, "Veuillez choisir la colonne à modifier",
                "Choisir Colonne", JOptionPane.QUESTION_MESSAGE, null, columnNames, columnNames[0]);

            if (selectedColumn != null) {
                int selectedColumnIndex = -1;
                for (int i = 0; i < columnNames.length; i++) {
                    if (columnNames[i].equals(selectedColumn)) {
                        selectedColumnIndex = i;
                        break;
                    }
                }

                if (selectedColumnIndex != -1) {
                    String currentValue = t.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                    String newValue = JOptionPane.showInputDialog(null, "Nouvelle valeur pour " + selectedColumn, "Modifié", JOptionPane.INFORMATION_MESSAGE, null, null, currentValue).toString();

                    if (newValue != null && !newValue.trim().isEmpty()) {
                        t.setValueAt(newValue, selectedRowIndex, selectedColumnIndex);

                        // Récupération des valeurs mises à jour
                        String date = t.getValueAt(selectedRowIndex, 0).toString();
                        String identifiant = t.getValueAt(selectedRowIndex, 1).toString();
                        String nombrePaquets = t.getValueAt(selectedRowIndex, 2).toString();
                        String type = t.getValueAt(selectedRowIndex, 3).toString();
                        String poids = t.getValueAt(selectedRowIndex, 4).toString();
                        String prix = t.getValueAt(selectedRowIndex, 5).toString();
                        String expediteur = t.getValueAt(selectedRowIndex, 6).toString();
                        String cni = t.getValueAt(selectedRowIndex, 7).toString();
                        String villeDepart = t.getValueAt(selectedRowIndex, 8).toString();
                        String tel = t.getValueAt(selectedRowIndex, 9).toString();
                        String recepteur = t.getValueAt(selectedRowIndex, 10).toString();
                        String villeArrive = t.getValueAt(selectedRowIndex, 11).toString();
                        String telRecepteur = t.getValueAt(selectedRowIndex, 12).toString();

                        // Mise à jour de la base de données
                        try {
                            classe.toutcolis.modifier(date, identifiant, nombrePaquets, type, poids, prix, expediteur, cni, villeDepart, tel, recepteur, villeArrive, telRecepteur);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(toutcolis.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La valeur saisie est invalide.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Colonne sélectionnée invalide.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à modifier.");
        }
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void btnexporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexporterActionPerformed
        try {
            // Récupérer le modèle de tableau du composant
            DefaultTableModel tab = (DefaultTableModel) tabtrans.getModel();
            // Appeler la méthode 'exporter' de la classe 'exporterclient' pour créer le fichier Excel
            exportercolis.exporter(tab);
            //            ouverture le fichier excel
            Desktop dk=Desktop.getDesktop();
            dk.open(new File ("C:/Users/Public/liste.xls"));
        } catch (Exception ex) {
            Logger.getLogger(exportercolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnexporterActionPerformed

    private void txtrechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercheKeyReleased
        DefaultTableModel t = (DefaultTableModel) tabtrans.getModel();
        t.setRowCount(0);
        String nom=txtrecherche.getText();
        try {
            classe.toutcolis.rechercher(t, nom);
        } catch (SQLException ex) {
            Logger.getLogger(formlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtrechercheKeyReleased

    private void tabtransMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabtransMouseReleased
         DefaultTableModel t = (DefaultTableModel) tabtrans.getModel();
        int selectedRowIndex = tabtrans.getSelectedRow();

       if (selectedRowIndex >= 0) {
        String[] columnNames = {"Date", "Identifiant", "Nombre de Paquets", "Prix", "Expéditeur", "Départ", "Type", "Téléphone"};
        String selectedColumn = (String) JOptionPane.showInputDialog(null, "Veuillez choisir la colonne à modifier",
                "Choisir Colonne", JOptionPane.QUESTION_MESSAGE, null, columnNames, columnNames[0]);

        if (selectedColumn != null) {
            int selectedColumnIndex = -1;
            for (int i = 0; i < columnNames.length; i++) {
                if (columnNames[i].equals(selectedColumn)) {
                    selectedColumnIndex = i;
                    break;
                }
            }

            if (selectedColumnIndex != -1) {
                String currentValue = t.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                String newValue = JOptionPane.showInputDialog(null, "Nouvelle valeur pour " + selectedColumn, "Modifier", JOptionPane.INFORMATION_MESSAGE, null, null, currentValue).toString();

                if (newValue != null && !newValue.trim().isEmpty()) {
                    t.setValueAt(newValue, selectedRowIndex, selectedColumnIndex);

                    // Récupération des valeurs mises à jour
                    String date = t.getValueAt(selectedRowIndex, 0).toString();
                    String identifiant = t.getValueAt(selectedRowIndex, 1).toString();
                    String nombrePaquets = t.getValueAt(selectedRowIndex, 2).toString();
                    String prix = t.getValueAt(selectedRowIndex, 3).toString();
                    String expediteur = t.getValueAt(selectedRowIndex, 4).toString();
                    String depart = t.getValueAt(selectedRowIndex, 5).toString();
                    String type = t.getValueAt(selectedRowIndex, 6).toString();
                    String tel = t.getValueAt(selectedRowIndex, 7).toString();

                    // Mise à jour de la base de données
                    classe.transfert.modifier(date, identifiant, nombrePaquets, prix, expediteur, depart, type, tel);
                } else {
                    JOptionPane.showMessageDialog(null, "La valeur saisie est invalide.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Colonne sélectionnée invalide.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à modifier.");
    }
    }//GEN-LAST:event_tabtransMouseReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexporter;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabtrans;
    private javax.swing.JTextField txtrecherche;
    // End of variables declaration//GEN-END:variables


    
}
