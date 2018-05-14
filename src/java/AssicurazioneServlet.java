/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author web4e
 */
public class AssicurazioneServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        int classe = Integer.parseInt(request.getParameter("classe"));
        int eta = Integer.parseInt(request.getParameter("eta"));
        
        int importo = 1500;
        if((classe > 7 && classe < 14) && eta < 25){
            importo = 1000;
        }
        request.getSession().setAttribute("importo", importo);
        response.sendRedirect("assicurazione.jsp");
        
    }
 
}
