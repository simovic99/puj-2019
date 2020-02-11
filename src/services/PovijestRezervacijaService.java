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
import knjiznica.model.PovijestRezervacijaModel;
import knjiznica.model.Baza;

/**
 *
 * @author korisnik
 */
public class PovijestRezervacijaService {
    
        public ObservableList<PovijestRezervacijaModel> dohvatiPovijestRezervacija() {
        ObservableList<PovijestRezervacijaModel> rezervacijeList = FXCollections.observableArrayList();
        Baza db = new Baza();
        String selectSQL = "SELECT r.id, kor.korisnicko_ime, k.naziv, a.ime, a.prezime, r.datum_od, r.datum_do FROM rezervacija r JOIN korisnik kor ON r.id_korisnika=kor.id JOIN knjiga k ON r.id_knjige=k.id JOIN autor a ON k.id_autora=a.id";

        try {
            PreparedStatement ps = db.exec(selectSQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {        
            PovijestRezervacijaModel a=new PovijestRezervacijaModel(rs.getInt("id"), rs.getString("korisnicko_ime"), rs.getString("naziv"), rs.getString("ime")+" "+rs.getString("prezime"), rs.getDate("datum_od"), rs.getDate("datum_do")); 
            rezervacijeList.add(a);
            }

	} catch (SQLException e) {
                Logger.getLogger(ClanoviService.class.getName()).log(Level.SEVERE, null, e);
                }
        return rezervacijeList;
    }
}
