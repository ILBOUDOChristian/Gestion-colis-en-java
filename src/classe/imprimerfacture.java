/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;

public class imprimerfacture {

    public static void imprimerPanel(JPanel panel) throws BadElementException, DocumentException {
        // Créer un fichier PDF temporaire
        File pdfFile;
        try {
            pdfFile = File.createTempFile("Document", ".pdf");
            pdfFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Générer le PDF
        try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
            // Créez un document avec la taille du JPanel
            Document document = new Document(new Rectangle(panel.getWidth(), panel.getHeight()));
            PdfWriter writer = PdfWriter.getInstance(document, fos);
            document.open();

            // Convertir le contenu du JPanel en image
            BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            panel.printAll(g2d);
            g2d.dispose();

            // Ajouter l'image au document PDF
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(bufferedImage, null);
            document.add(image);

            document.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Ouvrir le fichier PDF dans le lecteur PDF par défaut
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(pdfFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Desktop is not supported. Cannot open the PDF file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
