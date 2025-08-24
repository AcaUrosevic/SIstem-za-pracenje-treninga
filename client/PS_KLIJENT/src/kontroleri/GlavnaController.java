/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.GlavnaForma;
import kordinator.Kordinator;
import model.Trener;

/**
 *
 * @author Aca
 */
public class GlavnaController {
    GlavnaForma gf;

    public GlavnaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    public void otvoriFormu() {
        Trener t = Kordinator.getInstance().getUlogovani();
        String ime = t.getIme();
        String prezime = t.getPrezime();
        gf.getLblUlogovani().setText(ime + " " + prezime);
        gf.setVisible(true);
    }

    private void addActionListeners() {
        
    }
    
    
}
