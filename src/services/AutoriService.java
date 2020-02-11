/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import knjiznica.model.AutoriModel;
import knjiznica.model.Baza;
import interfaces.Autori;

/**
 *
 * @author korisnik
 */
public class AutoriService implements Autori {
    
        private String databaseError;
        public String getDatabaseError(){
        return databaseError;
        }
        
    @Override
    public Boolean dodajAutora(knjiznica.model.AutoriModel a) {
                Baza db = new Baza();
        PreparedStatement ps = db.exec("INSERT INTO autor(ime, prezime, datum_rodjenja) VALUES(?,?,?);");
        try {
            ps.setString(1, a.ime);
            ps.setString(2, a.prezime);
            ps.setString(3, a.datum_rodjenja);
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
    public ObservableList<AutoriModel> dohvatiAutore() {
             ObservableList<AutoriModel> autoriList = FXCollections.observableArrayList();
        Baza db = new Baza();
        		String selectSQL = "SELECT * from autor";

		try {
			PreparedStatement ps = db.exec(selectSQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
                          
                         AutoriModel a=new AutoriModel(rs.getInt("id"),rs.getString("ime"),rs.getString("prezime"),rs.getDate("datum_rodjenja")); 
                         autoriList.add(a);
			}

		} catch (SQLException e) {

			databaseError=e.getLocalizedMessage();

		}
        return autoriList;
    }

    @Override
    public Boolean obrisiAutora(int id) {
        Baza db=new Baza();
        String selectSQL = "Delete from autor where id="+id;
        	PreparedStatement ps = db.exec(selectSQL);
            try {
                boolean rs = ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(AutoriService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }

   @Override
    public Boolean urediAutora( AutoriModel a) {
        Baza db=new Baza();
        
        try{
        String selectSQL = "UPDATE autor SET ime=?, prezime=?, datum_rodjenja=? WHERE id=?";
        PreparedStatement ps = db.exec(selectSQL);

            ps.setString(1, a.ime);
            ps.setString(2, a.prezime);
            ps.setString(3, a.datum_rodjenja);
            ps.setInt(4, a.id);

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AutoriService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
}
