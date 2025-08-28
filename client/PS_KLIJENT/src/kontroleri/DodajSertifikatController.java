/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.DodajSertifikatForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.Sertifikat;
import model.TrenerSertifikat;

/**
 *
 * @author Aca
 */
public class DodajSertifikatController {
    DodajSertifikatForma forma;

    public DodajSertifikatController(DodajSertifikatForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu(){
        forma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        forma.setVisible(true);
    }
    
    private void addActionListeners() {
        forma.addBtnDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    LocalDate datumIzdavanja = LocalDate.parse(forma.getTxtDatumIzdavanja().getText());
                    if (datumIzdavanja.isAfter(LocalDate.now())) {
                        JOptionPane.showMessageDialog(forma, "Datum ne sme biti u buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                        }
                    String naziv = forma.getTxtNaziv().getText().trim();
                    String tip = forma.getTxtTip().getText().trim();
                    Sertifikat s = new Sertifikat(naziv, tip);
                    TrenerSertifikat ts = new TrenerSertifikat(Kordinator.getInstance().getUlogovani(), s, datumIzdavanja);
                    boolean uspeh = Komunikacija.getInstance().ubaciSertifikat(ts);
                    if(!uspeh){
                        JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti sertifikatt", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(forma, "Sistem je zapamtio sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    Kordinator.getInstance().osveziTabeluSertifikati();
                    forma.dispose();
                            
                }catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(forma, "Datum mora biti u formatu: yyyy-mm-dd", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
     
    
}
