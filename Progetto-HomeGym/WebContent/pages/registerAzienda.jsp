<%@page import="it.unisa.model.DAOS.*"%>
<%@page import="it.unisa.model.beans.*"%>
<%@page import="it.unisa.controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="icon" href="foto/logo.jpg" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomeGym - Registrazione Azienda</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="Stili/registrazione.css">
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<% request.setAttribute("tipo","Azienda"); %>
		<form action="/Progetto-HomeGym/RegistrazioneControl" method="post">

			<fieldset>
				
    <div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                        
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">REGISTRATI</h3>
                            </div>
                            <div class="card-body">
                         
                            <p id="error">
		                    </p> 
                                <form action="/Progetto-HomeGym/RegistrazioneControl" method="post">     
                                   <div class="form-group">
                                        <label  class="grassetto">&nbspRagione Sociale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="ragioneSociale" id="ragioneSociale" onclick="startRagioneSociale()" onkeyup="startRagioneSociale()" placeholder="Ragione Sociale" >
                                        <p id="errorRagioneSociale"></p>
                                    </div>                        
                                  <div class="form-group">
                                        <label  class="grassetto">&nbspPartita Iva</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="partitaIva" id="partitaIva" onclick="startPartitaIva()" onkeyup="startPartitaIva()" placeholder="Partita Iva">
                                        <p id="errorPartitaIva"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto">&nbspCittà della Sede Legale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="citta" id="citta" onclick="startCitta()" onkeyup="startCitta()" placeholder="Città della Sede Legale">
                                        <p id="errorCitta"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto">&nbspIndirizzo della Sede Legale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="indirizzp" id="indirizzo" onclick="startIndirizzo()" onkeyup="startIndirizzo()" placeholder="Indirizzo della Sede Legale">
                                        <p id="errorIndirizzo"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto">&nbspRecapito Telefonico</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="telefono" id="telefono" onclick="startTelefono()" onkeyup="startTelefono()" placeholder="Recapito Telefonico">
                                        <p id="errorTelefono"></p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/email.png" alt="">&nbspE-mail</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="email" id="email" onclick="startEmail()" onkeyup="startEmail()">
                                         <p id="errorEmail"></p>
                                    </div>
                                       <p id="errorE"></p>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password" id="password" onclick="startPassword()" onkeyup="startPassword()">
                                         <p id="errorP1" class="suggerimento">La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspRipeti&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password2" id="password2" onclick="startPassword2()" onkeyup="startPassword2()">
                                        <p id="errorP2" class="suggerimento"><p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Crea il tuo Account</button>
                                    <div>
                                     <p>Hai gia un account? <a id="linkReg" href="#">Accedi</a> </p> 
                                    </div>
                                </form>
                            </div>
                            
                        </div>
                        
    
                    </div>
    
    
                </div>
            
    
            </div>

        </div>

    </div>
			</fieldset>
		</form>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>