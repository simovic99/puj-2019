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
public class ClanoviModel {
    public int id;
    public String ime;
    public String prezime;
    public String datum_rodjenja;
    public String korisnicko_ime;
    public String lozinka;
    public String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //konstruktor za dodavanje
    public ClanoviModel(String ime, String prezime, LocalDate datum_rodjenja, String korisnicko_ime, String lozinka, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja.toString();
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.email = email;
    }

    //konstruktor za izlistavanje
    public ClanoviModel(int id, String ime, String prezime, Date datum_rodjenja, String korisnicko_ime, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja.toString();
        this.korisnicko_ime = korisnicko_ime;
        this.email = email;
    }

    //konstruktor za update
    public ClanoviModel(int id, String ime, String prezime, LocalDate datum_rodjenja, String korisnicko_ime, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja.toString();
        this.korisnicko_ime = korisnicko_ime;
        this.email = email;
    }

  
    
    
    
}
