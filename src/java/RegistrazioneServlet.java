/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UserDao;
import database.CrudException;
import entities.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author web4e
 */
public class RegistrazioneServlet extends HttpServlet {

    UserDao userDao = null;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = new UserDao(); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    
        try{
            Utente u = new Utente();
            
            u.setEmail(request.getParameter("email"));
            u.setNome(request.getParameter("nome"));
            u.setCognome(request.getParameter("cognome"));
            u.setCf(request.getParameter("cf"));
            u.setPassword(request.getParameter("password"));
            u.setDatanascita(new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("datanascita")).getTime()));
            
            userDao.add(u);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }

}
