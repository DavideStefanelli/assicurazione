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
public class BeanEntity {
    
    protected int id;
    protected String nome;
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
