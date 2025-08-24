/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.PrikazClanovaForma;
import forme.modeli.ModelTabeleClanovi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.ClanTeretane;

/**
 *
 * @author Aca
 */
public class PrikazClanovaController {
    PrikazClanovaForma pcf;

    public PrikazClanovaController(PrikazClanovaForma pcf) {
        this.pcf = pcf;
        addActionListeners();
    }
    
    public void otvoriFormu() {
        pripremiFormu();
        pcf.setVisible(true);
    }

    private void pripremiFormu() {
        List<ClanTeretane> clanovi = Komunikacija.getInstance().ucitajClanove();
        ModelTabeleClanovi mtc = new ModelTabeleClanovi(clanovi);
        pcf.getTblClanovi().setModel(mtc);
    }

    private void addActionListeners() {
        pcf.addObrisiActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = pcf.getTblClanovi().getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(pcf, "Sistem ne moze da obrise clana teretane", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleClanovi mtc = (ModelTabeleClanovi) pcf.getTblClanovi().getModel();
                ClanTeretane clan = mtc.getClanovi().get(selectedRow);
                boolean obrisan = Komunikacija.getInstance().obrisiPacijenta(clan);
                if(obrisan){
                    JOptionPane.showMessageDialog(pcf, "Sistem je obrisao clana teretane", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    mtc.removeAt(selectedRow);
                    return;
                }
                JOptionPane.showMessageDialog(pcf, "Sistem ne moze da obrise clana teretane", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
            
        });
    }
}
