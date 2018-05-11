<%-- 
    Document   : assicurazione
    Created on : 11-mag-2018, 12.05.32
    Author     : web4e
--%>


<%@page import="entities.Utente"%>
<% 
    
    Object userObj = session.getAttribute("utente"); 
    if(userObj == null){
        response.sendRedirect("login.jsp");
    }
    Utente utente = (Utente)userObj;
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
