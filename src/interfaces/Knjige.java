/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javafx.collections.ObservableList;
import knjiznica.model.KnjigeModel;

/**
 *
 * @author korisnik
 */
public interface Knjige {

public Boolean dodajKnjigu(knjiznica.model.KnjigeModel k);    
public ObservableList<KnjigeModel> dohvatiKnjige();
public Boolean obrisiKnjigu(int id);
public Boolean urediKnjigu(KnjigeModel k);
public Boolean urediStatusKnjige(knjiznica.model.KnjigeModel k);
}
