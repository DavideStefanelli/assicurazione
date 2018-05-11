/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.BeanEntity;
import java.sql.PreparedStatement; 
import entities.Prodotto;
import java.sql.SQLException;
import database.CrudException;
import database.DBConnectionException;
import database.DBManager;
/**
 *
 * @author web4e
 */
public class ProdottoDaoImpl implements CrudDao {
    
    private static final String insertProductSQL = "INSERT INTO prodotti (nome, cat_id) VALUES (?, ?)";

    @Override
    public BeanEntity find(String name) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BeanEntity find(int id) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String name) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(BeanEntity obj) throws CrudException {
        Prodotto p = null;
        try {
            p = (Prodotto)obj;
            PreparedStatement insertOperation = DBManager.getConnection().prepareStatement(insertProductSQL);
            insertOperation.setString(1, p.getNome());
            insertOperation.setInt(2, p.getCategory()); 
            insertOperation.executeUpdate();
            return true;
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean exists(int id) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String name) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
