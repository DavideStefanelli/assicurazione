/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author web4e
 */
public class Utente extends BeanEntity {
    
    private String cognome;
    private String email; 
    private String cf;
    private Date datanascita;
    private Date datacreazione;
    private String password;
    private Sesso sesso;
    public enum Sesso {Maschio, Femmina}
    
    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Date getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    public Date getDatacreazione() {
        return datacreazione;
    }

    public void setDatacreazione(Date datacreazione) {
        this.datacreazione = datacreazione;
    }

    
    
}
