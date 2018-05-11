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
 
    UserDao userDao = null;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = new UserDao(); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        
        try{

            String userEmail = request.getParameter("email"); 
            String password = request.getParameter("password");
            
            Utente utente = (Utente)userDao.find(userEmail);
            
            if(utente == null || (utente.getPassword().equals(password) == false)){ 
                response.sendRedirect("login.jsp"); 
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
