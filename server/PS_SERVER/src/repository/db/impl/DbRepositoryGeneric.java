/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import repository.db.DbRepository;
import java.sql.Statement;
import repository.db.DbConnectionFactory;
import java.sql.ResultSet;

/**
 *
 * @author Aca
 */
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat>{

    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> result = new ArrayList<>();
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if(uslov != null)
            upit += uslov;
        upit += ";";
        System.out.println(upit);
        Statement s = DbConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(upit);
        result = param.vratiListu(rs);
        rs.close();
        s.close();
        return result;
    }

    @Override
    public void add(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "INSERT INTO "+ param.vratiNazivTabele() + " (" + param.vratiKoloneZaUbacivanje() + ") VALUES(" + param.vratiVrednostiZaUbacivanje() + ");";
        System.out.println(upit);
        Statement s = DbConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(upit);
        s.close();
    }

    @Override
    public void edit(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "UPDATE " + param.vratiNazivTabele() + " SET " + param.vratiVrednostiZaIzmenu()  + " WHERE " + param.vratiPrimarniKljuc() + ";";
        System.out.println(upit);
        Statement s = DbConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(upit);
        s.close();
    }

    @Override
    public void delete(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "DELETE FROM " + param.vratiNazivTabele() + " WHERE " + param.vratiPrimarniKljuc() + ";";
        System.out.println(upit);
        Statement s = DbConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(upit);
        s.close();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int addAndReturnId(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "INSERT INTO " + param.vratiNazivTabele() + " (" +
                    param.vratiKoloneZaUbacivanje() + ") VALUES(" +
                    param.vratiVrednostiZaUbacivanje() + ");";
        System.out.println(upit);
        Statement s = DbConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = s.getGeneratedKeys();
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        s.close();
        if (id == -1) throw new Exception("Baza nije vratila generated key.");
        return id;
    }
    
    
    
}
