/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author korisnik
 */
public class ProfilModel {
    public String ime;
    public String prezime;
    public String datum_rodjenja;
    public String lozinka1;
    public String lozinka2;
    public String email;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(LocalDate datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja.toString();
    }

    public String getLozinka1() {
        return lozinka1;
    }

    public void setLozinka1(String lozinka1) {
        this.lozinka1 = lozinka1;
    }

    public String getLozinka2() {
        return lozinka2;
    }

    public void setLozinka2(String lozinka2) {
        this.lozinka2 = lozinka2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //konstruktor za ucitavanje korisnika
    public ProfilModel(String ime, String prezime, Date datum_rodjenja, String lozinka1, String lozinka2, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja.toString();
        this.lozinka1 = lozinka1;
        this.lozinka2 = lozinka2;
        this.email = email;
    }
    
    //konstruktor za update
      public ProfilModel(String ime, String prezime, LocalDate datum_rodjenja, String lozinka1, String lozinka2, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja.toString();
        this.lozinka1 = lozinka1;
        this.lozinka2 = lozinka2;
        this.email = email;
    }
}
