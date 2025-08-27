/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaEvidencijeTreninga;

/**
 *
 * @author Aca
 */
public class ModelTabeleStavke extends AbstractTableModel{
     List<StavkaEvidencijeTreninga> stavke;
    String [] kolone = {"Broj ponavljanja", "Broj serija", "Tezina", "Napor", "Vezba"};
    
    public ModelTabeleStavke(List<StavkaEvidencijeTreninga> stavke){
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaEvidencijeTreninga stavka = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0: return stavka.getBrojPonavljanja();
            case 1: return stavka.getBrojSerija();
            case 2: return stavka.getTezina();
            case 3: return stavka.getNaporVezbe();
            case 4: return stavka.getVezba().getNaziv();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<StavkaEvidencijeTreninga>getStavke() {
        return stavke;
    }

    public void removeAt(int selectedRow) {
        stavke.remove(selectedRow);
        fireTableRowsDeleted(selectedRow, selectedRow);
    }
    
}
