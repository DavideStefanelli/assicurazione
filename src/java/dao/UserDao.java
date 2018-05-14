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
import entities.Utente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

/**
 *
 * @author web4e
 */
public class UserDao implements CrudDao {

    private static final String insertUtenteSQL = "INSERT INTO utente (email,password,sale,cf,nome,cognome,datanascita,sesso,datacreazione) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
    private static final String findUserByIdSQL = "SELECT * FROM utente WHERE id = ?";
    private static final String authenticateUserSQL = "select * from utente where email = ? and SHA2(CONCAT(?, sale), 256) = password;";
    private static final String findUserByNameSQL = "SELECT * FROM utente WHERE email = ?";
    private static final String countUserSQL = "SELECT COUNT(*) FROM utente";
    
    @Override
    public BeanEntity find(String email) throws CrudException {
        try {
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(findUserByNameSQL);
            selectOperation.setString(1, email); 
            ResultSet rs = selectOperation.executeQuery();
            if (rs.next()) return readUtente(rs);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public BeanEntity find(String email, String password) throws CrudException {
        try {
            PreparedStatement selectOperation = DBManager.getConnection().prepareStatement(authenticateUserSQL);
            selectOperation.setString(1, email); 
            selectOperation.setString(2, password); 
            ResultSet rs = selectOperation.executeQuery();
            if (rs.next()) return readUtente(rs); 
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private Utente readUtente(ResultSet rs) throws Exception {
        Utente u = new Utente();
        u.setNome(rs.getString("nome"));
        u.setCognome(rs.getString("cognome"));
        u.setHashedPassword(rs.getString("password"));
        u.setSalePassword(rs.getString("sale"));
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
            selectOperation.setString(2, u.getHashedPassword()); 
            selectOperation.setString(3, u.getSalePassword());  
            selectOperation.setString(4, u.getCf()); 
            selectOperation.setString(5, u.getNome()); 
            selectOperation.setString(6, u.getCognome()); 
            selectOperation.setDate(7, u.getDatanascita()); 
            String sesso = (u.getSesso() == Utente.Sesso.Maschio ? "M" : "F");
            selectOperation.setString(8, sesso); 
            
            if(selectOperation.executeUpdate() == 1) return true;
            
        } catch(DBConnectionException | SQLException ex) {
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
        
    }
    
}
