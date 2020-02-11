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
public class KorisnickeRezervacijeModel {
    public String naziv;
    public String autor;
    public String vrsta;
    public Date datum_od;
    public Date datum_do;

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

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
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

    public KorisnickeRezervacijeModel(String naziv, String autor, String vrsta, Date datum_od, Date datum_do) {
        this.naziv = naziv;
        this.autor = autor;
        this.vrsta = vrsta;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }
    
    
}
