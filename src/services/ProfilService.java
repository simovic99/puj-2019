/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Profil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import knjiznica.controller.LoginController;
import knjiznica.model.Baza;
import knjiznica.model.ProfilModel;

/**
 *
 * @author korisnik
 */
public class ProfilService implements Profil{
    
    @Override
    public ProfilModel dohvatiKorisnika(int id){
    
        Baza db = new Baza();
        String selectSQL = "SELECT ime, prezime, datum_rodjenja, sifra, email FROM korisnik WHERE id="+LoginController.globalId;
            
            try {
                PreparedStatement ps = db.exec(selectSQL);
		ResultSet rs = ps.executeQuery();
       
			while (rs.next()) {
                        
                        ProfilModel p=new ProfilModel(rs.getString("ime"),rs.getString("prezime"),rs.getDate("datum_rodjenja"), rs.getString("sifra"), rs.getString("sifra"), rs.getString("email"));                        
                        return p;  
                        }
            } catch (SQLException ex) {
            Logger.getLogger(ProfilService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    return null;
    }
    
    @Override
    public Boolean urediKorisnika(ProfilModel p) {
        Baza db=new Baza();
        
        try{
        String selectSQL = "UPDATE korisnik SET ime=?, prezime=?, datum_rodjenja=?, sifra=?, email=? WHERE id="+LoginController.globalId;
        PreparedStatement ps = db.exec(selectSQL);

            ps.setString(1, p.ime);
            ps.setString(2, p.prezime);
            ps.setString(3, p.datum_rodjenja);
            ps.setString(4, p.lozinka1);
            ps.setString(5, p.email);

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AutoriService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
}
   
