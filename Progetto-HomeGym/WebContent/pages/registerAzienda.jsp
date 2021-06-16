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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../Stili/registrazione.css">
    <link rel="stylesheet" href="../Stili/header.css">
	<link rel="stylesheet" href="../Stili/footer.css">
	<script src="../jsMiei/footer.js"></script> 
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<% request.setAttribute("tipo","Azienda"); %>
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
                                <form action="/Progetto-HomeGym/RegistrazioneControl" method="post" onsubmit="return controlAzienda(this)">     
                                   <input type="hidden" name="tipo" value="Azienda">
                                   <div class="form-group">	
                                        <label  class="grassetto"><img src="foto/edificio.png" alt="">&nbspRagione Sociale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="ragioneSociale" id="ragioneSociale"  placeholder="Ragione Sociale" >
                         				<p id="errorRagSoc"></p>
                                    </div>                        
                                  <div class="form-group">
                                        <label  class="grassetto"><img src="foto/partitaiva.png" alt="">&nbspPartita Iva</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="partitaIva" id="partitaIva" placeholder="Partita Iva">
                                        <p id="errorPIVA"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/luogo.png" alt="">&nbspCittà della Sede Legale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="citta" id="citta" placeholder="Città della Sede Legale">
                                        <p id="errorCitta"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/luogo.png" alt="">&nbspIndirizzo della Sede Legale</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="indirizzo" id="indirizzo" placeholder="Indirizzo della Sede Legale">
                                       	<p id="errorInd"></p>
                                    </div>

                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/phone.png" alt="">&nbspRecapito Telefonico</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="telefono" id="telefono" placeholder="Recapito Telefonico">
                                        <p id="errorTel"></p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/email.png" alt="">&nbspE-mail</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="email" id="email" placeholder="Email">
                                    	<p id="errorEmail"></p>
                                    </div>
                                    <p id="errorE"></p>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDO" name="password" id="password" placeholder="Password">
                                        <p id="errorP1" class="suggerimento">La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspRipeti&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDO" name="password2" id="password2" placeholder="Ripeti Password">
                                        <p id="errorP2" class="suggerimento"><p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Crea il tuo Account</button>
                                    <div>
                                     <p>Hai gia un account? <a id="linkReg" href="../pages/login.jsp">Accedi</a> </p> 
                                     <p>Non hai un Account? <a id="linkReg" href="registerPersonaFisica.jsp">Registrati qui.</a> </p> 
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
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="../js/bootstrap.min.js"></script>
	</body>
</html>