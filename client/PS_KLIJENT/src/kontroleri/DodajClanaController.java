/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajClanaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
    DodajClanaForma forma;
    ClanTeretane clanZaIzmenu;

    public DodajClanaController(DodajClanaForma dcf, ClanTeretane clanZaIzmenu) {
        this.forma = dcf;
        this.clanZaIzmenu = clanZaIzmenu;
        addActionListeners();
    }

    private void addActionListeners() {
        forma.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = forma.getTxtIme().getText();
                String prezime = forma.getTxtPrezime().getText();
                String email = forma.getTxtEmail().getText();
                PaketUsluga paket = (PaketUsluga) forma.getCbPaketUsluga().getSelectedItem();
                
                ClanTeretane noviClan = new ClanTeretane(ime, prezime, email, paket);
                boolean dodatClan = Komunikacija.getInstance().dodajClanaTeretane(noviClan);
                if(dodatClan){
                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio clana teretane", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira clana teretane", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
                forma.dispose();
            }
        });
        
        forma.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = forma.getTxtIme().getText();
                String prezime = forma.getTxtPrezime().getText();
                String email = forma.getTxtEmail().getText();
                PaketUsluga paket = (PaketUsluga) forma.getCbPaketUsluga().getSelectedItem();
                
                ClanTeretane izmenjeni = new ClanTeretane(clanZaIzmenu.getIdClanTeretane(),ime, prezime, email, paket);
                boolean izmenjen = Komunikacija.getInstance().promeniClanaTeretane(izmenjeni);
                if(izmenjen){
                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio clana teretane", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje clana teretane po zadatom kriterijumu", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
                Kordinator.getInstance().osveziTabeluClanovi();
                forma.dispose();
            }
        });
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        forma.getBtnIzmeni().setVisible(false);
        ucitajPaketeUsluga();
    }

    public void otvoriFormuIzmena() {
        pripremiFormuIzmena();
        forma.setVisible(true);
    }
    
    private void pripremiFormuIzmena() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        forma.getBtnDodaj().setVisible(false);
        ucitajPaketeUsluga();
        forma.getTxtIme().setText(clanZaIzmenu.getIme());
        forma.getTxtPrezime().setText(clanZaIzmenu.getPrezime());
        forma.getTxtEmail().setText(clanZaIzmenu.getEmail());
        forma.getCbPaketUsluga().setSelectedItem(clanZaIzmenu.getPaketUsluga());
    }
    
    private void ucitajPaketeUsluga(){
        List<PaketUsluga> paketi = Komunikacija.getInstance().ucitajPakete();
        JComboBox cbPaketi = forma.getCbPaketUsluga();
        for (PaketUsluga pu : paketi) {
            cbPaketi.addItem(pu);
        }
    }
    
}
