/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajClanaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.ClanTeretane;
import model.PaketUsluga;

/**
 *
 * @author Aca
 */
public class DodajClanaController {
    DodajClanaForma dcf;
    ClanTeretane clanZaIzmenu;

    public DodajClanaController(DodajClanaForma dcf, ClanTeretane clanZaIzmenu) {
        this.dcf = dcf;
        this.clanZaIzmenu = clanZaIzmenu;
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
                }
                else{
                    JOptionPane.showMessageDialog(dcf, "Sistem ne moze da kreira clana teretane", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
                dcf.dispose();
            }
        });
        
        dcf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = dcf.getTxtIme().getText();
                String prezime = dcf.getTxtPrezime().getText();
                String email = dcf.getTxtEmail().getText();
                PaketUsluga paket = (PaketUsluga) dcf.getCbPaketUsluga().getSelectedItem();
                
                ClanTeretane izmenjeni = new ClanTeretane(clanZaIzmenu.getIdClanTeretane(),ime, prezime, email, paket);
                boolean izmenjen = Komunikacija.getInstance().promeniClanaTeretane(izmenjeni);
                if(izmenjen){
                    JOptionPane.showMessageDialog(dcf, "Sistem je zapamtio clana teretane", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                JOptionPane.showMessageDialog(dcf, "Sistem ne moze da nadje clana teretane po zadatom kriterijumu", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
                Kordinator.getInstance().osveziTabeluClanovi();
                dcf.dispose();
            }
        });
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        dcf.setVisible(true);
    }

    private void pripremiFormu() {
        dcf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dcf.getBtnIzmeni().setVisible(false);
        ucitajPaketeUsluga();
    }

    public void otvoriFormuIzmena() {
        pripremiFormuIzmena();
        dcf.setVisible(true);
    }
    
    private void pripremiFormuIzmena() {
        dcf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dcf.getBtnDodaj().setVisible(false);
        ucitajPaketeUsluga();
        dcf.getTxtIme().setText(clanZaIzmenu.getIme());
        dcf.getTxtPrezime().setText(clanZaIzmenu.getPrezime());
        dcf.getTxtEmail().setText(clanZaIzmenu.getEmail());
        dcf.getCbPaketUsluga().setSelectedItem(clanZaIzmenu.getPaketUsluga());
    }
    
    private void ucitajPaketeUsluga(){
        List<PaketUsluga> paketi = Komunikacija.getInstance().ucitajPakete();
        JComboBox cbPaketi = dcf.getCbPaketUsluga();
        for (PaketUsluga pu : paketi) {
            cbPaketi.addItem(pu);
        }
    }
    
}
