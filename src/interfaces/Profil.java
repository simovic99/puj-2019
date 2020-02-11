/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import knjiznica.model.ProfilModel;

/**
 *
 * @author korisnik
 */
public interface Profil {
     public ProfilModel dohvatiKorisnika(int id);
     public Boolean urediKorisnika(ProfilModel p);
}
