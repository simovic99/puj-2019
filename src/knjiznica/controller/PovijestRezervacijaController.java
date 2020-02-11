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
import knjiznica.model.PovijestRezervacijaModel;
import services.PovijestRezervacijaService;

/**
 *
 * @author korisnik
 */
public class PovijestRezervacijaController {
    @FXML
    TableView<PovijestRezervacijaModel>tablica;
    @FXML
    TableColumn<PovijestRezervacijaModel, Number> id;
    @FXML
    TableColumn<PovijestRezervacijaModel, String> korisnickoIme;
    @FXML
    TableColumn<PovijestRezervacijaModel, String> nazivKnjige;
    @FXML
    TableColumn<PovijestRezervacijaModel, String> autorKnjige;
    @FXML
    TableColumn<PovijestRezervacijaModel, LocalDate> datumOd;
    @FXML
    TableColumn<PovijestRezervacijaModel, LocalDate> datumDo;
    
   
    @FXML           //da se odmah pozove funkcija prilikom ucitavanja subscene
    void initialize(){
        izlistajPovijestRezervacija();
    }
    
    public void izlistajPovijestRezervacija(){
       PovijestRezervacijaService prs=new PovijestRezervacijaService();
       ObservableList<PovijestRezervacijaModel> rez;
       rez = prs.dohvatiPovijestRezervacija();
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        korisnickoIme.setCellValueFactory(new PropertyValueFactory<>("korisnicko_ime"));
        nazivKnjige.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        autorKnjige.setCellValueFactory(new PropertyValueFactory<>("autor"));
        datumOd.setCellValueFactory(new PropertyValueFactory<>("datum_od"));
        datumDo.setCellValueFactory(new PropertyValueFactory<>("datum_do"));
        tablica.setItems(rez);
    }
}
