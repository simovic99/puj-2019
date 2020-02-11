/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javafx.collections.ObservableList;
import knjiznica.model.AutoriModel;

/**
 *
 * @author korisnik
 */
public interface Autori {
    public Boolean dodajAutora(AutoriModel a);
    public ObservableList<AutoriModel> dohvatiAutore();
    public Boolean obrisiAutora(int id);
    public Boolean urediAutora(AutoriModel a);
}
