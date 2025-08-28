/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class ModelTabeleSertifikati extends AbstractTableModel{
    String[] kolone = {"Naziv", "Tip"};
    List<TrenerSertifikat> sertifikati;
    
    public ModelTabeleSertifikati(List<TrenerSertifikat> sertifikati){
        this.sertifikati = sertifikati;
    }
    
    
    @Override
    public int getRowCount() {
        return sertifikati.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TrenerSertifikat sertifikat = sertifikati.get(rowIndex);
        switch (columnIndex) {
            case 0: return sertifikat.getSertifikat().getNaziv();
            case 1: return sertifikat.getSertifikat().getTip();
            case 3: return sertifikat.getDatumIzdavanja();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
