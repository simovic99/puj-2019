/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Clanovi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import knjiznica.model.Baza;
import knjiznica.model.ClanoviModel;

/**
 *
 * @author korisnik
 */
public class ClanoviService implements Clanovi {
 
     private String databaseError;
     
     public String getDatabaseError(){
        return databaseError;
        }   
    
    @Override
    public Boolean dodajClana(knjiznica.model.ClanoviModel c) {
        Baza db = new Baza();
        PreparedStatement ps = db.exec("INSERT INTO korisnik (ime, prezime, datum_rodjenja, korisnicko_ime, sifra, email, id_tipa_korisnika) VALUES(?,?,?,?,?,?,2);");
        try {
            ps.setString(1, c.ime);
            ps.setString(2, c.prezime);
            ps.setString(3, c.datum_rodjenja);
            ps.setString(4, c.korisnicko_ime);
            ps.setString(5, c.lozinka);
            ps.setString(6, c.email);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            databaseError=ex.getMessage();
            System.out.println("Nastala je greška: " + ex.getMessage());
            return false;
        }
    }   
 
    @Override
    public ObservableList<ClanoviModel> dohvatiClanove() {
        ObservableList<ClanoviModel> clanoviList = FXCollections.observableArrayList();
            Baza db = new Baza();
            String selectSQL = "SELECT id, ime, prezime, datum_rodjenja, korisnicko_ime, email from korisnik";

		try {
			PreparedStatement ps = db.exec(selectSQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
                          
                         ClanoviModel c=new ClanoviModel(rs.getInt("id"),rs.getString("ime"),rs.getString("prezime"),rs.getDate("datum_rodjenja"), rs.getString("korisnicko_ime"), rs.getString("email")); 
                         clanoviList.add(c);
			}

		} catch (SQLException e) {

			databaseError=e.getLocalizedMessage();
		}
        return clanoviList;
    }
    
    @Override
    public Boolean obrisiClana(int id) {
        Baza db=new Baza();
        String selectSQL = "Delete from korisnik where id="+id;
        	PreparedStatement ps = db.exec(selectSQL);
            try {
                boolean rs = ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(ClanoviService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }   
 
    @Override
    public Boolean urediClana(ClanoviModel c) {
        Baza db=new Baza();
       
        try{
        String selectSQL = "UPDATE korisnik SET ime=?, prezime=?, datum_rodjenja=?, korisnicko_ime=?, email=? WHERE id=?";
        PreparedStatement ps = db.exec(selectSQL);

            ps.setString(1, c.ime);
            ps.setString(2, c.prezime);
            ps.setString(3, c.datum_rodjenja);
            ps.setString(4, c.korisnicko_ime);
            ps.setString(5, c.email);
            ps.setInt(6, c.id);

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KnjigeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    } 
    
    
}
