/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import knjiznica.model.ProfilModel;
import services.ProfilService;

/**
 *
 * @author korisnik
 */
public class ProfilController {
    
    @FXML
    TextField imeKorisnika;
    @FXML
    TextField prezimeKorisnika;
    @FXML
    DatePicker datumKorisnika;
    @FXML
    TextField lozinka1;
    @FXML
    TextField lozinka2;
    @FXML
    TextField emailKorisnika;
    @FXML
    Label status;
    
    
    @FXML           //da se odmah pozove funkcija prilikom ucitavanja subscene
    void initialize(){
        urediProfil();
    }
    
    
    public void urediProfil(){
        ProfilService ps=new ProfilService();
        ProfilModel p = ps.dohvatiKorisnika(LoginController.globalId);
        imeKorisnika.setText(p.ime);
        prezimeKorisnika.setText(p.prezime);
        LocalDate ld=LocalDate.parse(p.datum_rodjenja);
        datumKorisnika.setValue(ld);
        lozinka1.setText(p.lozinka1);
        lozinka2.setText(p.lozinka2);
        emailKorisnika.setText(p.email);
    }
    
    public void spremiPromjene(){
        ProfilModel p = new ProfilModel (imeKorisnika.getText(), prezimeKorisnika.getText(), datumKorisnika.getValue(), lozinka1.getText(), lozinka2.getText(), emailKorisnika.getText() );
        if (lozinka1.getText().equals(lozinka2.getText())){
            ProfilService ps=new ProfilService();
            ps.urediKorisnika(p);
             status.setText("Spremili ste promjene!");
        }
        
        else{
             status.setText("Lozinke se ne podudaraju! Pokušajte ponovo.");
        }
        }
    
    
    
}
    

