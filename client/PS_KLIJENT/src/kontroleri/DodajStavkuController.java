/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajStavkuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.StavkaEvidencijeTreninga;
import model.Vezba;

/**
 *
 * @author Aca
 */
public class DodajStavkuController {
    DodajStavkuForma forma;

    public DodajStavkuController(DodajStavkuForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    private void addActionListeners() {
        forma.addVezbaChangeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vezba v = (Vezba) forma.getCbVezba().getSelectedItem();
                forma.getTxtNapor().setText(v.getNapor() + "");
            }
        });
        forma.addStavkaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int brojPonavljanja = Integer.parseInt(forma.getTxtBrojPonavljanja().getText());
                    int brojSerija = Integer.parseInt(forma.getTxtBrojSerija().getText());
                    try{
                        double tezina = Double.parseDouble(forma.getTxtTezina().getText());
                        double napor = Double.parseDouble(forma.getTxtNapor().getText());
                        Vezba v = (Vezba) forma.getCbVezba().getSelectedItem();
                        StavkaEvidencijeTreninga stavka = new StavkaEvidencijeTreninga(0, null, brojPonavljanja, brojSerija, tezina, napor, v);

                        boolean dodana = Kordinator.getInstance().dodajStavku(stavka);
                        if(dodana){
                            JOptionPane.showMessageDialog(forma, "Uspesno si dodao stavku", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                            forma.dispose();
                            return;
                        }
                        JOptionPane.showMessageDialog(forma, "Evidencija vec sadrzi stavku sa istim rednim brojem", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(forma, "Polja tezina i napor moraju biti brojevi", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(forma, "Polja rb, brojPonavljanja i brojSerija moraju biti celi brojevi", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        });
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        forma.setVisible(true);
    }

    private void pripremiFormu() {
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        forma.getTxtNapor().setEditable(false);
        ucitajVezbe();    
    }

    private void ucitajVezbe() {
        List<Vezba> vezbe = Komunikacija.getInstance().vratiListuVezbi();
        for (Vezba vezba : vezbe) {
            forma.getCbVezba().addItem(vezba);
        }
    }
    
    
}
