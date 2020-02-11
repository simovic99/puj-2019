/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import knjiznica.model.KorisnickeRezervacijeModel;
import services.KorisnickeRezervacijeService;

/**
 *
 * @author korisnik
 */
public class KorisnickeRezervacijeController {
    @FXML
    TableView<KorisnickeRezervacijeModel>tablica;
    @FXML
    TableColumn<KorisnickeRezervacijeModel, String> nazivKnjige;
    @FXML
    TableColumn<KorisnickeRezervacijeModel, String> autorKnjige;
    @FXML
    TableColumn<KorisnickeRezervacijeModel, String> vrstaKnjige;
    @FXML
    TableColumn<KorisnickeRezervacijeModel, LocalDate> datumOd;
    @FXML
    TableColumn<KorisnickeRezervacijeModel, LocalDate> datumDo;
    
   
    @FXML           //da se odmah pozove funkcija prilikom ucitavanja subscene
    void initialize(){
        izlistajRezervacije();
    }
    
    public void izlistajRezervacije(){
       KorisnickeRezervacijeService krs=new KorisnickeRezervacijeService();
       ObservableList<KorisnickeRezervacijeModel> kor_rez;
       kor_rez = krs.dohvatiRezervacije();
      
        nazivKnjige.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        autorKnjige.setCellValueFactory(new PropertyValueFactory<>("autor"));
        vrstaKnjige.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        datumOd.setCellValueFactory(new PropertyValueFactory<>("datum_od"));
        datumDo.setCellValueFactory(new PropertyValueFactory<>("datum_do"));
        tablica.setItems(kor_rez);
    }
    
    
}
