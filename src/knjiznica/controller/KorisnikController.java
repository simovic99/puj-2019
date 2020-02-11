/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import knjiznica.model.KnjigeModel;

/**
 *
 * @author korisnik
 */
public class KorisnikController {

@FXML
Button odjava;
@FXML
Button profil;
@FXML
Button rezervacija;
@FXML
Button korisnikRezervacije;
@FXML
BorderPane border_pane;
   

    @FXML
    TableView<KnjigeModel>tablica;
    @FXML
    TableColumn<KnjigeModel, String> nazivKnjige;
    @FXML
    TableColumn<KnjigeModel, String> autorKnjige;
    @FXML
    TableColumn<KnjigeModel, String> vrstaKnjige;
    @FXML
    TableColumn<KnjigeModel,Number> idKnjige;

    public void odjaviSe(ActionEvent e) {
    try {
        Parent root;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Login.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 450, 450));
     
        odjava.getScene().getWindow().hide();
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void ucitajProfil(ActionEvent e) throws IOException{
        Parent prof = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Profil.fxml"));
        border_pane.setCenter(prof);
 
}
    
    
    public void ucitajRezervaciju (ActionEvent e) throws IOException{
        Parent rez = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Rezervacija.fxml"));
        border_pane.setCenter(rez);
        
    }
    
    public void ucitajKorisnickeRezervacije(ActionEvent e) throws IOException{
        Parent kor_rez = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/KorisnickeRezervacije.fxml"));
        border_pane.setCenter(kor_rez);

    }

    
}
