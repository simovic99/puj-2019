/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import knjiznica.model.Baza;

/**
 *
 * @author korisnik
 */
public class RezervacijaService {
    
    
    public Boolean dodajRezervaciju(knjiznica.model.RezervacijaModel r){
       Baza db = new Baza();
        PreparedStatement ps = db.exec("INSERT INTO rezervacija(id_korisnika, id_knjige, datum_od, datum_do) VALUES(?,?,?,?);");
        
        try {
            ps.setInt(1, r.id_korisnika);
            ps.setInt(2, r.id_knjige);
            ps.setString(3, r.datum_od.toString());
            ps.setString (4, r.datum_do.toString());
            
            int rs = ps.executeUpdate();
              if (rs == 1) {
                return true;
            } else {
                return false;
            }
            
         } catch (SQLException ex) {
            Logger.getLogger(RezervacijaService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
     public Boolean urediStatusKnjige(knjiznica.model.RezervacijaModel r) {
        Baza db=new Baza();
        
        try{
        String selectSQL = "UPDATE knjiga SET status=? WHERE id=?";
        PreparedStatement ps = db.exec(selectSQL);

            ps.setInt(1, 1);
            ps.setInt (2, r.id_knjige);

            ps.executeUpdate();
            

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KnjigeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
}
