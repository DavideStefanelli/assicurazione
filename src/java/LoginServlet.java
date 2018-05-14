import dao.UserDao;
import database.CrudException;
import entities.Utente;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
 
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        String action = request.getParameter("action");
        System.out.println("GET METHOD");
        if(action.equals("logout")){ 
            System.out.println(action);
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        UserDao userDao = new UserDao();
        
        try{

            String userEmail = request.getParameter("email"); 
            String password = request.getParameter("password");
            
            Utente utente = (Utente)userDao.find(userEmail, password);
            
            if(utente == null || (utente.passwordMatches(password) == false)){ 
                response.sendRedirect("login.jsp?status=fail"); 
            } else {                 
                HttpSession sessione = request.getSession();
                sessione.setAttribute("utente", utente);
                response.sendRedirect("assicurazione.jsp");
            }
             
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }

}
