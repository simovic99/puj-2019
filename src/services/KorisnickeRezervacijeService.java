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
import knjiznica.controller.LoginController;
import knjiznica.model.Baza;
import knjiznica.model.KorisnickeRezervacijeModel;

/**
 *
 * @author korisnik
 */
public class KorisnickeRezervacijeService {
    
    
    public ObservableList<KorisnickeRezervacijeModel> dohvatiRezervacije() {
        ObservableList<KorisnickeRezervacijeModel> rezervacijeList = FXCollections.observableArrayList();
        Baza db = new Baza();
        String selectSQL = "SELECT k.naziv, a.ime, a.prezime, k.vrsta, r.datum_od, r.datum_do FROM rezervacija r JOIN knjiga k ON r.id_knjige=k.id JOIN autor a ON k.id_autora=a.id WHERE r.id_korisnika="+LoginController.globalId;

        try {
            PreparedStatement ps = db.exec(selectSQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {        
            KorisnickeRezervacijeModel k=new KorisnickeRezervacijeModel(rs.getString("naziv"), rs.getString("ime")+" "+rs.getString("prezime"), rs.getString("vrsta"), rs.getDate("datum_od"), rs.getDate("datum_do")); 
            rezervacijeList.add(k);
            }

	} catch (SQLException e) {
                Logger.getLogger(ClanoviService.class.getName()).log(Level.SEVERE, null, e);
                }
        return rezervacijeList;
    }
    
}
