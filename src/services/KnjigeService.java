/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Knjige;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import knjiznica.model.Baza;
import knjiznica.model.KnjigeModel;

/**
 *
 * @author korisnik
 */
public class KnjigeService implements Knjige {
  
       
    private String databaseError;
     
    public String getDatabaseError(){
        return databaseError;
        }     
    
    
    @Override 
    public Boolean dodajKnjigu(knjiznica.model.KnjigeModel k){
       Baza db = new Baza();
        PreparedStatement ps = db.exec("INSERT INTO knjiga(naziv, vrsta, status, id_autora) VALUES(?,?,?,?);");
        try {
            ps.setString(1, k.naziv);
            ps.setString(2, k.vrsta);
            ps.setInt(3, 0);
            ps.setInt (4, k.idAutora);
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
    public ObservableList<KnjigeModel> dohvatiKnjige() {
        ObservableList<KnjigeModel> knjigeList = FXCollections.observableArrayList();
            Baza db = new Baza();
            String selectSQL = "SELECT k.id, k.naziv, a.ime, a.prezime, k.vrsta, k.status FROM knjiga k JOIN autor a ON k.id_autora=a.id";

		try {
			PreparedStatement ps = db.exec(selectSQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
                          
                         KnjigeModel k=new KnjigeModel(rs.getInt("id"),rs.getString("naziv"), rs.getString("ime")+" "+rs.getString("prezime"), rs.getString("vrsta"), rs.getInt("status")); 
                         knjigeList.add(k);
			}

		} catch (SQLException e) {

			databaseError=e.getLocalizedMessage();
		}
        return knjigeList;
    }
    
    @Override
    public Boolean obrisiKnjigu(int id) {
        Baza db=new Baza();
        String selectSQL = "DELETE FROM knjiga WHERE id="+id;
        	PreparedStatement ps = db.exec(selectSQL);
            try {
                boolean rs = ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(ClanoviService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }  
   
    @Override
    public Boolean urediKnjigu(KnjigeModel k) {
        Baza db=new Baza();
        
        try{
        String selectSQL = "UPDATE knjiga SET naziv=?, vrsta=? WHERE id=?";
        PreparedStatement ps = db.exec(selectSQL);

            ps.setString(1, k.naziv);
            ps.setString(2, k.vrsta);
            ps.setInt(3, k.id);

            ps.executeUpdate();
            

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KnjigeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
        @Override
        public Boolean urediStatusKnjige(knjiznica.model.KnjigeModel k) {
        Baza db=new Baza();
        
        try{
        String selectSQL = "UPDATE knjiga SET status=? WHERE id=?";
        PreparedStatement ps = db.exec(selectSQL);

            ps.setInt(1, 0);
            ps.setInt (2, k.id);

            ps.executeUpdate();
            

            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KnjigeService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
}
    

