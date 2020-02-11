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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import knjiznica.model.AutoriModel;
import services.AutoriService;


public class AutoriController{
Parent root;

    @FXML
    AnchorPane urediAutora;
    @FXML
    TextField lblData;
    AutoriModel a;
    @FXML
    TextField imeAutora;
    @FXML
    TextField prezimeAutora;
    @FXML
    DatePicker datumAutora;
    @FXML
    Button spremiAutora;
    @FXML
    Label status;
    @FXML
    TableView<AutoriModel>tablica;
    @FXML
    TableColumn<AutoriModel,Number> idAutor;
    @FXML
    TableColumn<AutoriModel, String> imeAutor;
    @FXML
    TableColumn<AutoriModel, String> prezimeAutor;
    @FXML
    TableColumn<AutoriModel, String> datum_rodjenjaAutor;
    @FXML
    Button uredi;
    @FXML
    TextField updateId;
    @FXML
    TextField updateImeAutora;
    @FXML
    TextField updatePrezimeAutora;
    @FXML
    DatePicker updateDatumAutora;

    
    
    public void spremiAutora(ActionEvent e) {
       String ime = imeAutora.getText();
       String prezime = prezimeAutora.getText();
       LocalDate d = datumAutora.getValue();
 
   if (imeAutora.getText().equals("") || prezimeAutora.getText().equals("")|| d==null){
        status.setText ("Morate unijeti sve vrijednosti!");
   }
   else{
     AutoriModel a=new AutoriModel(ime,prezime,d);
     AutoriService as=new AutoriService();
     Boolean dodajAutora = as.dodajAutora(a);
    if(dodajAutora){
            status.setText("Uspješno ste dodali autora!");
        }
        else{
            status.setText("Pogreška: "+ as.getDatabaseError());
        }
    }
}
       
    public void izbrisiAutora(){
          AutoriModel a = tablica.getSelectionModel().getSelectedItem();
          AutoriService as=new AutoriService();
          
           if(as.obrisiAutora(a.id)){
              izlistajAutora();
           }
    }
    
    
    public void ucitajUpdateAutor (ActionEvent e){
        urediAutora.setVisible(true);
        AutoriModel a = tablica.getSelectionModel().getSelectedItem();
        updateImeAutora.setText(a.ime);
        updatePrezimeAutora.setText(a.prezime);
        LocalDate ld=LocalDate.parse(a.datum_rodjenja);
        updateDatumAutora.setValue(ld);
        updateId.setText(a.id+"");
 
    }
       
    public void azurirajAutor( ){
        AutoriModel a=new AutoriModel(Integer.parseInt(updateId.getText()),updateImeAutora.getText(), updatePrezimeAutora.getText(), updateDatumAutora.getValue());
        AutoriService as=new AutoriService();
        as.urediAutora(a);
        urediAutora.setVisible(false);
        izlistajAutora();
     
    }
       
    public  void izlistajAutora(){
       AutoriService as=new AutoriService();
       ObservableList<AutoriModel> autori;
       autori = as.dohvatiAutore();
       
      imeAutor.setCellFactory(TextFieldTableCell.forTableColumn());
      prezimeAutor.setCellFactory(TextFieldTableCell.forTableColumn());
      datum_rodjenjaAutor.setCellFactory(TextFieldTableCell.forTableColumn());
      
        idAutor.setCellValueFactory(new PropertyValueFactory<>("Id"));
        imeAutor.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeAutor.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        datum_rodjenjaAutor.setCellValueFactory(new PropertyValueFactory<>("datum_rodjenja"));
        tablica.setItems(autori);
      }
       
}
