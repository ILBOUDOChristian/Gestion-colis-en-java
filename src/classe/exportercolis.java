/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author NNB
 */
public class exportercolis {
    public static void exporter(DefaultTableModel tab) throws WriteException{
        try {
            int nl=tab.getRowCount();
            int nc=tab.getColumnCount();
//creation une feuille excel
            WritableWorkbook fe=Workbook.createWorkbook( new File ("C:/Users/Public/liste.xls"));
            WritableSheet f=fe.createSheet("Liste", 0);
            Label lab;
//creation entete
            for(int i=1;i<nc;i++){
            lab=new Label(i-1,0,tab.getColumnName(i));//parcourir la ligne
            f.addCell(lab);
}
//remplissage de la feuille
            for(int j=0;j<nl;j++){
    
                for(int c=1;c<nc;c++){
                   lab=new Label(c-1,j+1,tab.getValueAt(j,c).toString());//parcourir la ligne
                   f.addCell(lab);
                }
}
            fe.write();//fin d'ecriture dans la feuille excel
            fe.close();
        } catch (IOException ex) {
            Logger.getLogger(exportercolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
