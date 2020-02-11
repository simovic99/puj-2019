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
public class AutoriModel {
    public int id;
    public String ime;
    public String prezime;
    public String datum_rodjenja;
    
    
    
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

    //konstruktor za dodavanje
    public AutoriModel(String ime, String prezime, LocalDate datum_rodjenja){
        this.ime=ime;
        this.prezime=prezime;
        this.datum_rodjenja=datum_rodjenja.toString() ; 
    }
    
    //konstruktor za izlistavanje
    public AutoriModel(int aInt, String string, String string0, Date date) {
            this.id=aInt;
            this.ime=string;
            this.prezime=string0;
            this.datum_rodjenja=date.toLocalDate().toString();
    }
    
    //konstruktor za update
    public AutoriModel(int Id,String ime, String prezime, LocalDate datum_rodjenja){
        this.id=Id;
        this.ime=ime;
        this.prezime=prezime;
        this.datum_rodjenja=datum_rodjenja.toString() ;  
    }
    
}
