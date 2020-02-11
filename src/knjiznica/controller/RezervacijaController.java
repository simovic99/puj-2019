/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import knjiznica.model.KnjigeModel;
import knjiznica.model.RezervacijaModel;
import services.KnjigeService;
import services.RezervacijaService;

/**
 *
 * @author korisnik
 */
public class RezervacijaController {
    
    @FXML
    TableView<KnjigeModel>tablica;
    @FXML
    TableColumn<KnjigeModel,Number> idKnjige;
    @FXML
    TableColumn<KnjigeModel, String> nazivKnjige;
    @FXML
    TableColumn<KnjigeModel, String> autorKnjige;
    @FXML
    TableColumn<KnjigeModel, String> vrstaKnjige;
    @FXML
    TableColumn<KnjigeModel,Number> statusKnjige;
    @FXML
    AnchorPane pane;
    @FXML
    DatePicker datumOd;
    @FXML
    DatePicker datumDo;
    @FXML
    Label label;

    
    @FXML           //da se odmah pozove funkcija prilikom ucitavanja subscene
    void initialize(){
        izlistajKnjige();
    }

    public  void izlistajKnjige(){
       KnjigeService ks=new KnjigeService();
       ObservableList<KnjigeModel> knjige;
       knjige = ks.dohvatiKnjige();
      
        idKnjige.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazivKnjige.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        autorKnjige.setCellValueFactory(new PropertyValueFactory<>("autor"));
        vrstaKnjige.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        statusKnjige.setCellValueFactory(new PropertyValueFactory<>("status"));
        tablica.setItems(knjige);
    }
    
    public void rezervirajKnjigu(){
        KnjigeModel k = tablica.getSelectionModel().getSelectedItem();
        int status = (int)statusKnjige.getCellData(k);
        int id_korisnika = LoginController.globalId;
        int id_knjige = (int)idKnjige.getCellData(k);
        LocalDate d_od = datumOd.getValue();
        LocalDate d_do = datumDo.getValue();
        
        if (d_od==null || d_do==null){
                    label.setText("Odaberite datume rezervacije!");
                    }
        else{
        if (status==0){
                    RezervacijaModel r = new RezervacijaModel (id_korisnika, id_knjige, d_od, d_do);
                    RezervacijaService rs = new RezervacijaService();
                 
                    if (rs.dodajRezervaciju(r)){
                        label.setText("Uspješno ste rezervirali knjigu!"); 
                    }
                    
                    RezervacijaModel r1 = new RezervacijaModel(id_knjige, status);
                    rs.urediStatusKnjige(r1);  
                    }
        else{
            label.setText("Odabrana knjiga je već rezervirana!");
            }
        }
    }
        
    
    
    }
    
    

