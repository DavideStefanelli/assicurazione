/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.CrudException;
import database.DBConnectionException;
import database.DBManager;
import entities.BeanEntity;
import entities.Categoria;
import entities.Utente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author web4e
 */
public class UserDao implements CrudDao {

    private static final String insertUtenteSQL = "INSERT INTO utente (email,password,cf,nome,cognome,datanascita,sesso,datacreazione) VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
    private static final String findUserByIdSQL = "SELECT * FROM utente WHERE id = ?";
    private static final String findUserByNameSQL = "SELECT * FROM utente WHERE email = ?";
    private static final String countUserSQL = "SELECT COUNT(*) FROM utente";
    
    @Override
    public BeanEntity find(String email) throws CrudException {
        try {
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(findUserByNameSQL);
            selectOperation.setString(1, email); 
            ResultSet rs = selectOperation.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setPassword(rs.getString("password"));
                u.setCf(rs.getString("cf"));
                u.setEmail(rs.getString("email"));
                u.setDatanascita(rs.getDate("datanascita"));
                u.setDatacreazione(rs.getDate("datacreazione"));
                if(rs.getString("sesso").equals("M")){
                    u.setSesso(Utente.Sesso.Maschio);
                }else{
                    u.setSesso(Utente.Sesso.Femmina);
                }
                
                return u;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(int id) throws CrudException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String name) throws CrudException {
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
        
        try {
            Utente u = (Utente)obj;
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(insertUtenteSQL);
            selectOperation.setString(1, u.getEmail()); 
            selectOperation.setString(2, u.getPassword()); 
            selectOperation.setString(3, u.getCf()); 
            selectOperation.setString(4, u.getNome()); 
            selectOperation.setString(5, u.getCognome()); 
            selectOperation.setDate(6, u.getDatanascita()); 
            String sesso = (u.getSesso() == Utente.Sesso.Maschio ? "M" : "F");
            selectOperation.setString(7, sesso); 
            
            if(selectOperation.executeUpdate() == 1) return true;
            
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
        
    }
    
}
