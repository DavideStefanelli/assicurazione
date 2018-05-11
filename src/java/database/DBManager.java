
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;

    private static String _host;
    private static String _db;
    private static String _user;
    private static String _password;
    
    public static void init(String host, String db, String user, String password) {
        _host = host;
        _db = db;
        _user = user;
        _password = password;
    }
    
    public static Connection getConnection() throws DBConnectionException { 
        //DEBUG
        init("localhost", "assicurazione", "root", "");
        
        try {
            Class.forName(MYSQL_DRIVER);
            
            conn = DriverManager.getConnection("jdbc:mysql://" + _host + ":3306/" + _db, _user, _password);
            return conn;
        } catch(Exception e) {
            throw new DBConnectionException("Errore di connessione al db");
        }
    }
    
    public static void closeConnection() {
        try {
            if(conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    
    
}
