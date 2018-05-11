/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entities.BeanEntity;
import database.CrudException;

/**
 *
 * @author web4e
 */
public interface CrudDao {
    
    public BeanEntity find(String name)         throws CrudException;
    public BeanEntity find(int id)              throws CrudException;
    public boolean exists(int id)               throws CrudException;
    public boolean exists(String name)         throws CrudException;
    public int count()                          throws CrudException;
    public void delete(int id)                  throws CrudException;
    public void delete(String name)             throws CrudException;
    public boolean add(BeanEntity obj)          throws CrudException;
    
    
}
