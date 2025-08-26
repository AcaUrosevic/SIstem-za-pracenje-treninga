/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajClanaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.ClanTeretane;
import model.PaketUsluga;

/**
 *
 * @author Aca
 */
public class DodajClanaController {
    DodajClanaForma dcf;

    public DodajClanaController(DodajClanaForma dcf) {
        this.dcf = dcf;
        addActionListeners();
    }

    private void addActionListeners() {
        dcf.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = dcf.getTxtIme().getText();
                String prezime = dcf.getTxtPrezime().getText();
                String email = dcf.getTxtEmail().getText();
                PaketUsluga paket = (PaketUsluga) dcf.getCbPaketUsluga().getSelectedItem();
                
                ClanTeretane noviClan = new ClanTeretane(ime, prezime, email, paket);
                boolean dodatClan = Komunikacija.getInstance().dodajClanaTeretane(noviClan);
                if(dodatClan){
                    JOptionPane.showMessageDialog(dcf, "Sistem je zapamtio clana teretane", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(dcf, "Sistem ne moze da kreira clana teretane", "GRESKA", JOptionPane.ERROR_MESSAGE);
                dcf.dispose();
            }
        });
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        dcf.setVisible(true);
    }

    private void pripremiFormu() {
        List<PaketUsluga> paketi = Komunikacija.getInstance().ucitajPakete();
        JComboBox cbPaketi = dcf.getCbPaketUsluga();
        for (PaketUsluga pu : paketi) {
            System.out.println(pu);
            cbPaketi.addItem(pu);
        }
    }
    
    
}
