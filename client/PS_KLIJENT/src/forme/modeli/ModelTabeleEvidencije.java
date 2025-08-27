/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.EvidencijaTreninga;

/**
 *
 * @author Aca
 */
public class ModelTabeleEvidencije extends AbstractTableModel{
    List<EvidencijaTreninga> evidencije;
    List<EvidencijaTreninga> fullEvidencije;
    String [] kolone = {"Trener", "Clan teretane", "Datum treninga", "Intenzitet"};
    
    public ModelTabeleEvidencije(List<EvidencijaTreninga> evidencije){
        this.evidencije = evidencije;
        this.fullEvidencije = evidencije;
    }
    
    @Override
    public int getRowCount() {
        return evidencije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //ClanTeretane clan = evidencije.get(rowIndex);
        switch (columnIndex) {
            case 0: return evidencije.get(rowIndex).getTrener().getIme() + " " + evidencije.get(rowIndex).getTrener().getPrezime();
            case 1: return evidencije.get(rowIndex).getClanTeretane().getIme() + " " + evidencije.get(rowIndex).getClanTeretane().getPrezime();
            case 2: return evidencije.get(rowIndex).getDatumTreninga();
            case 3: return evidencije.get(rowIndex).getIntenzitet();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<EvidencijaTreninga> getEvidencije() {
        return evidencije;
    }
}
