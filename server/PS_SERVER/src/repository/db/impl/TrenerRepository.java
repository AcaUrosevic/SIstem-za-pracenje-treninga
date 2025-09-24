/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.Trener;

/**
 *
 * @author Aca
 */
public class TrenerRepository extends DbRepositoryGeneric{
    @SuppressWarnings("unchecked")
    public List<Trener> pretraziPoImenu(Trener t) throws Exception{
        List<?> tmp = getAll(t, "WHERE ime = " + t.getIme());
        return (List<Trener>)(List<?>) tmp;
    }
}
