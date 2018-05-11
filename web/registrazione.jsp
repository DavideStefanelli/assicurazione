<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Registrazione</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/BasicWebApp/css/bootstrap.min.css">
    </head>
 
    <style> 
        .form-signin{
            max-width: 330px; 
            margin: auto;
        } 
    </style>
    
    <body>
        
        <div class="container">
          <form class="form-signin" name="myForm" method="POST" action="login">
            <h2>Registrazione</h2>
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
            
            <label for="inputNome" class="sr-only">Nome</label>
            <input type="text" id="inputNome" class="form-control" name="nome" placeholder="Nome" required autofocus>
            
            <label for="inputCognome" class="sr-only">Cognome</label>
            <input type="text" id="inputCognome" class="form-control" name="nome" placeholder="Cognome" required autofocus>
            
            <label for="codiceFiscale" class="sr-only">Codice Fiscale</label>
            <input type="text" id="codiceFiscale" class="form-control" name="cf" placeholder="Codice Fiscale" required autofocus>
            
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" class="form-control" name="password" placeholder="Password" required autofocus>
            
            <label for="inputDataNascita" class="sr-only">Data di nascita</label> 
            <input type="date" id="inputDataNascita" name="datanascita" max="3000-12-31" min="1000-01-01" class="form-control" required>
            
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                  <input type="radio" name="options" id="option1" autocomplete="off" checked> Active
                </label>
                <label class="btn btn-secondary">
                  <input type="radio" name="options" id="option2" autocomplete="off"> Radio
                </label>
                <label class="btn btn-secondary">
                  <input type="radio" name="options" id="option3" autocomplete="off"> Radio
                </label>
            </div>
            
            <button class="btn btn-lg btn-primary btn-block" type="submit">Registrati</button>
          </form>

        </div>
        
        <script src="/BasicWebApp/js/bootstrap.min.js"></script>
        
    </body>
</html>