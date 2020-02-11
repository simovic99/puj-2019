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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author korisnik
 */
public class AdminController {
    
@FXML
Button odjava;
@FXML
Button autori;
@FXML
Button knjige;
@FXML
Button clanovi;
@FXML
BorderPane border_pane;

    
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
    
    public void ucitajAutore(ActionEvent e) throws IOException{
        Parent autor = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Autori.fxml"));
        border_pane.setCenter(autor);
    }
    
    public void ucitajKnjige(ActionEvent e) throws IOException{
        Parent knjiga = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Knjige.fxml"));
        border_pane.setCenter(knjiga);
       
    }
    
    public void ucitajClanove(ActionEvent e) throws IOException{
  
        Parent clan = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Clanovi.fxml"));
        border_pane.setCenter(clan);

    }
    
    public void ucitajRezervacije(ActionEvent e) throws IOException{
  
        Parent rez = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/PovijestRezervacija.fxml"));
        border_pane.setCenter(rez);

    }

 } 
    
