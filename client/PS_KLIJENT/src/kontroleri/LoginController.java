/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import model.Trener;

/**
 *
 * @author Aca
 */
public class LoginController {
    
    final LoginForma forma;

    public LoginController(LoginForma lf) {
        this.forma = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        forma.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = forma.getTxtUsername().getText().trim();
                String password = String.valueOf(forma.getPassPassword().getPassword());
                
                Komunikacija.getInstance().konekcija();
                Trener trener = Komunikacija.getInstance().login(username, password);
                
                if(trener == null){
                    JOptionPane.showMessageDialog(forma, "Korisnicko ime i sifra nisu ispravni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(forma, "Korisnicko ima i sifra su ispravni", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Kordinator.getInstance().setUlogovani(trener);
                Kordinator.getInstance().otvoriGlavnuFormu();
                forma.dispose();
            }
        });
    }

    public void otvoriFormu() {
        forma.setVisible(true);
    }
    
    
}
