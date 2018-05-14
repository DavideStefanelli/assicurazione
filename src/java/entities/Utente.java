/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Date;
import java.util.Base64; 
import utilis.Util;

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
    private String hashedPassword;
    private String salePassword;
    private Sesso sesso;
    
    public enum Sesso {Maschio, Femmina}
    
    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }
    
    public void setHashedPassword(String pass){
        this.hashedPassword = pass;
    }
    
    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalePassword() {
        return salePassword;
    }
    
    

    public void setSalePassword(String salePassword) {
        this.salePassword = salePassword;
    } 
    
    public boolean passwordMatches(String pass){
        String computedHash = Util.hashPassword(pass, salePassword);
        if(this.hashedPassword.equals(computedHash)){
            return true;
        }else{
            return false;
        }
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
