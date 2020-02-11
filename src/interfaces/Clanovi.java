/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javafx.collections.ObservableList;
import knjiznica.model.ClanoviModel;

/**
 *
 * @author korisnik
 */
public interface Clanovi {
    public Boolean dodajClana(knjiznica.model.ClanoviModel c);
    public ObservableList<ClanoviModel> dohvatiClanove();
    public Boolean obrisiClana(int id);
    public Boolean urediClana(ClanoviModel c);
}
