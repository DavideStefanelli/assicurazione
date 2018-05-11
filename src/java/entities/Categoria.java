/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author web4e
 */
public class Categoria extends BeanEntity {
    private String descrizione;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public static Categoria create(int id, String nome, String descrizione){
        Categoria c = new Categoria();
        c.setId(id);
        c.setNome(nome);
        c.setDescrizione(descrizione);
        return c;
    } 
    
}
