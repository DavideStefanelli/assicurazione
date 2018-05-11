/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.BeanEntity;
import entities.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.CrudException;
import database.DBConnectionException;
import database.DBManager;

/**
 *
 * @author web4e
 */
public class CategoriaDaoImpl implements CrudDao {
    
    private static final String insertCatSQL = "INSERT INTO categoria (nome, descrizione) VALUES (?, ?)";
    private static final String findCatByIdSQL = "SELECT * FROM categoria WHERE id = ?";
    private static final String findCatByNameSQL = "SELECT * FROM categoria WHERE nome = ?";
    private static final String countCatSQL = "SELECT COUNT(*) FROM categoria";
    
    @Override
    public BeanEntity find(String name) throws CrudException {
        try {
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(findCatByNameSQL);
            selectOperation.setString(1, name); 
            ResultSet rs = selectOperation.executeQuery();
            if (rs.next()) {
                return Categoria.create(rs.getInt("id"), rs.getString("nome"), rs.getString("descrizione"));
            } 
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public BeanEntity find(int id) throws CrudException {
        try {
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(findCatByIdSQL);
            selectOperation.setInt(1, id); 
            ResultSet rs = selectOperation.executeQuery();
            if (rs.next()) {
                return Categoria.create(rs.getInt("id"), rs.getString("nome"), rs.getString("descrizione"));
            }
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() throws CrudException {
        try { 
            PreparedStatement insertOperation = DBManager.getConnection().prepareStatement(countCatSQL);  
            ResultSet rs = insertOperation.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return -1;
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
        try {
            Categoria c = (Categoria)obj;
            PreparedStatement insertOperation = DBManager.getConnection().prepareStatement(insertCatSQL, Statement.RETURN_GENERATED_KEYS);
            insertOperation.setString(1, c.getNome());
            insertOperation.setString(2, c.getDescrizione()); 
            insertOperation.executeUpdate();
            ResultSet rs = insertOperation.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
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
        return find(id) != null;
    }

    @Override
    public boolean exists(String name) throws CrudException {
        return find(name) != null;
    }
    
}
