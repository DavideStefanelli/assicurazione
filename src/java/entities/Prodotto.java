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
public class Prodotto extends BeanEntity {
    private int cat_id;
    private String cat_name;
    
    public int getCategory() {
        return cat_id;
    }

    public void setCategoria(int cat_id) {
        this.cat_id = cat_id;
    }
    
    public void setCategoria(Categoria cat) {
        this.cat_id = cat.getId();
    }

    public String getCategoria() {
        return cat_name;
    }

    public void setCategoria(String cat_name) {
        this.cat_name = cat_name;
    }
    
    
    
    
}
