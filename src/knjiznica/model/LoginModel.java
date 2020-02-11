/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjiznica.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import knjiznica.controller.LoginController;

public class LoginModel {
    public static String logiraj (String kime, String lozinka) {
        String returnValue="";
        Baza db = new Baza();
        PreparedStatement ps = db.exec("SELECT * FROM korisnik WHERE korisnicko_ime =? AND "
                + "sifra=?");
        try {
            ps.setString(1, kime);
            ps.setString(2, lozinka);
       
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoginController.globalId=rs.getInt("id");
                if(kime.compareTo("admin")==0){
                    returnValue="admin";
                      
                }
                else{
                    
                    returnValue="korisnik";
                }
            }
        } catch (SQLException ex) {
            System.out.println("Nastala je greška: "+ex.getMessage());
            return returnValue;
           // return false;
        }
        return returnValue;
    
}
}
