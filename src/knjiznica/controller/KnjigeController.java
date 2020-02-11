/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import knjiznica.model.AutoriModel;
import knjiznica.model.KnjigeModel;
import services.AutoriService;
import services.KnjigeService;

/**
 *
 * @author korisnik
 */

public class KnjigeController {
    @FXML
    TableView<KnjigeModel>tablica;
    @FXML
    TableColumn<KnjigeModel,Number> idKnjiga;
    @FXML
    TableColumn<KnjigeModel, String> nazivKnjiga;
    @FXML
    TableColumn<KnjigeModel, String> autorKnjiga;
    @FXML
    TableColumn<KnjigeModel, String> vrstaKnjiga;
    @FXML
    TableColumn<KnjigeModel,Number> statusKnjiga;
    @FXML
    AnchorPane urediKnjigu;
    @FXML
    TextField updateIdKnjige;
    @FXML
    TextField updateNazivKnjige;
    @FXML
    TextField updateVrstaKnjige;
    @FXML
    ComboBox autorList;
    @FXML
    TextField nazivKnjige;
    @FXML
    TextField IdAutora;
    @FXML
    TextField vrstaKnjige;
    @FXML
    Label status;
    @FXML
    Label label;
    
    public void spremiKnjigu(){
        String naziv = nazivKnjige.getText();
        int autor = Integer.parseInt(IdAutora.getText());
        String vrsta = vrstaKnjige.getText();
        
        if (nazivKnjige.getText().equals("") || vrstaKnjige.getText().equals("")){
        status.setText ("Morate unijeti sve vrijednosti!");
        }
        else{
        KnjigeModel k = new KnjigeModel(naziv,vrsta,autor);
        KnjigeService ks=new KnjigeService();
        if(ks.dodajKnjigu(k)){
            status.setText("Uspješno ste dodali knjigu!");
        }
        else{
            status.setText("Pogreška: "+ ks.getDatabaseError());
        }
    }
    }
   
    
    public  void izlistajKnjige(){
       KnjigeService ks=new KnjigeService();
       ObservableList<KnjigeModel> knjige;
       knjige = ks.dohvatiKnjige();
      
        idKnjiga.setCellValueFactory(new PropertyValueFactory<>("id"));
        nazivKnjiga.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        autorKnjiga.setCellValueFactory(new PropertyValueFactory<>("autor"));
        vrstaKnjiga.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        statusKnjiga.setCellValueFactory(new PropertyValueFactory<>("status"));
        tablica.setItems(knjige);
    }
    
    
    public void izbrisiKnjigu(){
        KnjigeModel k = tablica.getSelectionModel().getSelectedItem();
        KnjigeService ks=new KnjigeService();
          
        if(ks.obrisiKnjigu(k.id)){
            izlistajKnjige();
           }
    }
    
   
    public void ucitajUpdateKnjiga (ActionEvent e){
        urediKnjigu.setVisible(true);
        KnjigeModel k = tablica.getSelectionModel().getSelectedItem();
        updateIdKnjige.setText(k.id+"");
        updateNazivKnjige.setText(k.naziv);
        updateVrstaKnjige.setText(k.vrsta);  
    }
    
    
    public void azurirajKnjigu( ){
        KnjigeModel k=new KnjigeModel(Integer.parseInt(updateIdKnjige.getText()), updateNazivKnjige.getText(), updateVrstaKnjige.getText());
        KnjigeService ks=new KnjigeService();
        ks.urediKnjigu(k);
        urediKnjigu.setVisible(false);
        izlistajKnjige();
    }  
    
    
    public void popuniListu(){
        AutoriService as=new AutoriService();
        autorList.setItems(as.dohvatiAutore());
        
        
        Callback<ListView<AutoriModel>, ListCell<AutoriModel>> factory = lv -> new ListCell<AutoriModel>() {
            @Override
            protected void updateItem(AutoriModel item, boolean empty) {
            super.updateItem(item, empty);
            setText(empty ? "" : item.getIme()+" "+item.getPrezime());
            }
            };
    autorList.setCellFactory(factory);
    autorList.setButtonCell(factory.call(null));
    autorList.setItems(as.dohvatiAutore());
    }
    
    
    public void dohvatiId(){
            AutoriModel a=(AutoriModel) autorList.getValue();
            IdAutora.setText(""+a.id);
    }
    
    
    public void vratiKnjigu(){
        KnjigeModel k = tablica.getSelectionModel().getSelectedItem();
        int id = (int)idKnjiga.getCellData(k);
        int stat = (int)statusKnjiga.getCellData(k);
        
        KnjigeModel k1 = new KnjigeModel(id, stat);
        KnjigeService ks = new KnjigeService ();
        if(ks.urediStatusKnjige(k1)){ 
        label.setText("Promijenili ste status knjige u: slobodna!");
        }
        izlistajKnjige();
       
        
    }
    
}
    
    
