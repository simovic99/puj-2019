/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.model;

/**
 *
 * @author korisnik
 */
public class KnjigeModel {
    public int id;
    public String naziv;
    public String autor;
    public String vrsta;
    public int status;
    public int idAutora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
     public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(int idAutora) {
        this.idAutora = idAutora;
    }

    
    
    //konstruktor za izlistavanje
    public KnjigeModel(int id, String naziv, String autor, String vrsta, int status) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.vrsta = vrsta;
        this.status = status;
    }
    
    //konstruktor za dodavanje
    public KnjigeModel(String naziv, String vrsta,int idAutora) {
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.idAutora = idAutora;
    }

    //konstruktor za update
    public KnjigeModel(int id, String naziv, String vrsta) {
        this.id = id;
        this.naziv = naziv;
        this.vrsta = vrsta;
    }

    //konstruktor za status knjige
    public KnjigeModel(int id, int status) {
        this.id = id;
        this.status = status;
    }

    




    
    
}
