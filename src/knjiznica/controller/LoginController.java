/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import knjiznica.model.LoginModel;


public class LoginController implements Initializable {
public static int globalId;
    @FXML
    Label statusLbl;
    
    @FXML
    TextField kimeTxt;
    
    @FXML
    PasswordField lozinkaTxt;
    
    public void prijaviSe (ActionEvent e) {
        String kime = kimeTxt.getText();
        String lozinka = lozinkaTxt.getText();
        
        if (kime.equals("") || lozinka.equals("")) {
            statusLbl.setText("Morate unijeti sve vrijednosti!");
        } else {
            String returnValue=LoginModel.logiraj(kime, lozinka);
            if (returnValue.compareTo("")!=0) {
                try {
                    statusLbl.setTextFill(Color.GREEN);
                    statusLbl.setText("Uspješno ste se prijavili");
                    Parent root;
      if(returnValue.compareTo("admin")==0){
          root = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Admin.fxml"));
      }
      else  root = FXMLLoader.load(getClass().getClassLoader().getResource("knjiznica/view/Korisnik.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 850, 700));
                    stage.show();
                    statusLbl.getScene().getWindow().hide();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                statusLbl.setText("Korisnicki podatci nisu ispravni!");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
