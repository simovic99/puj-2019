/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import knjiznica.model.ClanoviModel;
import services.ClanoviService;

/**
 *
 * @author korisnik
 */
public class ClanoviController {
    
    
    @FXML
    TextField imeClana;
    @FXML
    TextField prezimeClana;
    @FXML
    DatePicker datumClana;
    @FXML
    TextField emailClana;
    @FXML
    TextField korImeClana;
    @FXML
    TextField lozinkaClana;
    @FXML
    Button spremiClana;
    @FXML
    Label status;
    @FXML
    TableView<ClanoviModel>tablica;
    @FXML
    TableColumn<ClanoviModel,Number> idClan;
    @FXML
    TableColumn<ClanoviModel, String> imeClan;
    @FXML
    TableColumn<ClanoviModel, String> prezimeClan;
    @FXML
    TableColumn<ClanoviModel, String> datum_rodjenjaClan;
    @FXML
    TableColumn<ClanoviModel, String> korisnicko_imeClan;
    @FXML
    TableColumn<ClanoviModel, String> lozinkaClan;
    @FXML
    TableColumn<ClanoviModel, String> emailClan;
    @FXML
    AnchorPane urediClana;
    @FXML
    TextField updateId;
    @FXML
    TextField updateImeClana;
    @FXML
    TextField updatePrezimeClana;
    @FXML
    DatePicker updateDatumClana;
    @FXML
    TextField updateKorImeClana;
    @FXML
    TextField updateEmailClana;
    
    
    public void spremiClana(ActionEvent e){
        String ime = imeClana.getText();
        String prezime = prezimeClana.getText();
        LocalDate d = datumClana.getValue();
        String korIme = korImeClana.getText();
        String loz = lozinkaClana.getText();
        String email = emailClana.getText();
 
      if (imeClana.getText().equals("") || prezimeClana.getText().equals("")||d==null || korImeClana.getText().equals("") || lozinkaClana.getText().equals("") || emailClana.getText().equals("")){
        status.setText ("Morate unijeti sve vrijednosti!");
        }
      else{
        ClanoviModel c=new ClanoviModel(ime,prezime,d,korIme,loz,email);
        ClanoviService cs=new ClanoviService();
        Boolean dodajClana = cs.dodajClana(c);
      if(dodajClana){
            status.setText("Uspješno ste dodali člana!");
           }
      else{
            status.setText("Pogreška: "+ cs.getDatabaseError());
          }
      }
    }
    
    
    public  void izlistajClanove(){
       ClanoviService cs=new ClanoviService();
       ObservableList<ClanoviModel> clanovi;
       clanovi = cs.dohvatiClanove();
      
        idClan.setCellValueFactory(new PropertyValueFactory<>("id"));
        imeClan.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeClan.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        datum_rodjenjaClan.setCellValueFactory(new PropertyValueFactory<>("datum_rodjenja"));
        korisnicko_imeClan.setCellValueFactory(new PropertyValueFactory<>("korisnicko_ime"));
        emailClan.setCellValueFactory(new PropertyValueFactory<>("email")); 
        tablica.setItems(clanovi);
      }      
     
    
    public void izbrisiClana(){
        ClanoviModel c = tablica.getSelectionModel().getSelectedItem();
        ClanoviService cs=new ClanoviService();
          
        if(cs.obrisiClana(c.id)){
            izlistajClanove();
           }
    } 
    
    public void ucitajUpdateClan (ActionEvent e){
        urediClana.setVisible(true);
        ClanoviModel c = tablica.getSelectionModel().getSelectedItem();
        updateId.setText(c.id+"");
        updateImeClana.setText(c.ime);
        updatePrezimeClana.setText(c.prezime);
        LocalDate ld=LocalDate.parse(c.datum_rodjenja);
        updateDatumClana.setValue(ld);
        updateKorImeClana.setText(c.korisnicko_ime);
        updateEmailClana.setText(c.email);

    }
  
      public void azurirajClan( ){
        ClanoviModel c=new ClanoviModel(Integer.parseInt(updateId.getText()), updateImeClana.getText(), updatePrezimeClana.getText(), updateDatumClana.getValue(), updateKorImeClana.getText(), updateEmailClana.getText());
        ClanoviService cs=new ClanoviService();
        cs.urediClana(c);
        urediClana.setVisible(false);
        izlistajClanove();
     
    }  
    
}