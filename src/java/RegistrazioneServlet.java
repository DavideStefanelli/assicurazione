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
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilis.Util;

/**
 *
 * @author web4e
 */
public class RegistrazioneServlet extends HttpServlet {
 
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        UserDao userDao = new UserDao();
        
        try{
            Utente u = new Utente();
            
            u.setEmail(request.getParameter("email"));
            u.setNome(request.getParameter("nome"));
            u.setCognome(request.getParameter("cognome"));
            u.setCf(request.getParameter("cf"));
             
            u.setSalePassword(Long.toUnsignedString(ThreadLocalRandom.current().nextLong())); 
            u.setHashedPassword(Util.hashPassword(request.getParameter("password"), u.getSalePassword()));
            
            if(request.getParameter("sesso").equals("M")){
                u.setSesso(Utente.Sesso.Maschio);
            }else{
                u.setSesso(Utente.Sesso.Femmina);
            }
            u.setDatanascita(new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("datanascita")).getTime()));
            
            userDao.add(u);
            
            response.sendRedirect("login.jsp");
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }

}
