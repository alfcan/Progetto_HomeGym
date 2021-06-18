<%@page import="it.unisa.model.DAOS.*"%>
<%@page import="it.unisa.model.beans.*"%>
<%@page import="it.unisa.controller.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="icon" href="foto/logofavicon.png" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomeGym - Registrazione</title>
    <link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/footer.css" %>>
	<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/header.css" %>>
	<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
	<link rel="stylesheet" href=<%=request.getContextPath() + "/css/bootstrap.min.css" %>>
	<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script> 
	<script src="<%=request.getContextPath() + "/jsMiei/controlliRegistrazione.js"%>"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp"%>
	

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
                         
                            <p id="error"></p> 
                                <form action="/Progetto-HomeGym/RegistrazioneControl" method="post" onsubmit="return controlPersonaFisica(this)">     
                                   	<input type="hidden" name="tipo" value="Persona Fisica">
                                   	<div class="form-group">
                                        <label  class="grassetto"><img src="foto/ominologin.PNG" alt="">&nbspCognome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="cognome" id="cognome" placeholder="Cognome" onclick="startCognome()" onkeyup="startCognome()">
                                        <p id="errorCognome"></p>
                                    </div>                        
                                  	<div class="form-group">
                                        <label  class="grassetto"><img src="foto/ominologin.PNG" alt="">&nbspNome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="nome" id="nome" placeholder="Nome" onclick="startNome()" onkeyup="startNome()">
                                        <p id="errorNome"></p>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/phone.png" alt="">&nbspRecapito Telefonico</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="telefono" id="telefono" placeholder="Recapito Telefonico" onclick="startTel()" onkeyup="startTel()">
                                        <p id="errorTel"></p>
                                    </div>

                                    <div>
                                        <label  class="grassetto"><img src="foto/genere.jpg" alt="">&nbspGenere</label><br>
                                        <label for="uomo">Uomo</label>
			                            <input id="uomo" type="radio" name="genere" value="Uomo" required><br>
			                            <label for="donna">Donna</label>
				                        <input type="radio" id="donna" name="genere" value="Donna"><br>  
                                    </div>
                                    
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/email.png" alt="">&nbspE-mail</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="email" id="email" placeholder="Email" onclick="startEmail()" onkeyup="startEmail()">
                                        <p id="errorEmail"></p>
                                    </div>
                                    <p id="errorE"></p>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDO" name="password" id="password" placeholder="Password" onclick="startPassword()" onkeyup="startPassword()">
                                         <p id="errorP1" class="suggerimento">La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.PNG" alt="">&nbspRipeti&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDO" name="password2" id="password2" placeholder="Ripeti Password" onclick="startPassword2()" onkeyup="startPassword2()">
                                        <p id="errorP2" class="suggerimento"><p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Crea il tuo Account</button>
                                    <div>
                                     <p>Hai gia un account? <a id="linkReg" href="../pages/login.jsp">Accedi</a> </p> 
                                     <p>Sei un'azienda e non sei ancora registrata? <a id="linkReg" href="registerAzienda.jsp">Registrati qui.</a> </p> 
                                    </div>
                                </form>
                            </div>
                            
                        </div>
                        
    
                    </div>
    
    
                </div>
            
    
            </div>

        </div>

    </div>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="../js/bootstrap.min.js"></script>
	</body>
</html>