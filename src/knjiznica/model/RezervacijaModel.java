/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.model;

import java.time.LocalDate;

/**
 *
 * @author korisnik
 */
public class RezervacijaModel {
    public int id_korisnika;
    public int id_knjige;
    public LocalDate datum_od;
    public LocalDate datum_do;
    public int status_knjige;

    public int getId_korisnika() {
        return id_korisnika;
    }

    public void setId_korisnika(int id_korisnika) {
        this.id_korisnika = id_korisnika;
    }

    public int getId_knjige() {
        return id_knjige;
    }

    public void setId_knjige(int id_knjige) {
        this.id_knjige = id_knjige;
    }

    public LocalDate getDatum_od() {
        return datum_od;
    }

    public void setDatum_od(LocalDate datum_od) {
        this.datum_od = datum_od;
    }

    public LocalDate getDatum_do() {
        return datum_do;
    }

    public void setDatum_do(LocalDate datum_do) {
        this.datum_do = datum_do;
    }

    public int getStatus_knjige() {
        return status_knjige;
    }

    public void setStatus_knjige(int status_knjige) {
        this.status_knjige = status_knjige;
    }
    

    public RezervacijaModel(int id_korisnika, int id_knjige, LocalDate datum_od, LocalDate datum_do) {
        this.id_korisnika = id_korisnika;
        this.id_knjige = id_knjige;
        this.datum_od = datum_od;
        this.datum_do = datum_do;
    }

    public RezervacijaModel(int id_knjige, int status_knjige) {
        this.status_knjige = status_knjige;
        this.id_knjige = id_knjige;
    }
    
    
    
}
