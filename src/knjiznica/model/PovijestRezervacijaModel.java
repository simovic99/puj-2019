/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.model;

import java.sql.Date;
/**
 *
 * @author korisnik
 */

public class PovijestRezervacijaModel {
    public int id;
    public String korisnicko_ime;
    public String naziv;
    public String autor;
    public Date datum_od;
    public Date datum_do;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDatum_od() {
        return datum_od;
    }

    public void setDatum_od(Date datum_od) {
        this.datum_od = datum_od;
    }

    public Date getDatum_do() {
        return datum_do;
    }

    public void setDatum_do(Date datum_do) {
        this.datum_do = datum_do;
    }

    public PovijestRezervacijaModel(int id, String korisnicko_ime, String naziv, String autor, Date datum_od, Date datum_do) {
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.naziv = naziv;
        this.autor = autor;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }
    
    
}
