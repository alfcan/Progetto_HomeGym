<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - Registrazione Azienda</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<% request.setAttribute("tipo","Azienda"); %>
		<form action="/Progetto-HomeGym/RegistrazioneControl" method="post">

			<fieldset>
				<legend>Registrazione azienda</legend>
				<input type="hidden" name="tipo" value="Persona Fisica">
				<label for="ragioneSociale">Ragione Sociale</label>
			    <input id="ragioneSociale" type="text" name="ragioneSociale" placeholder="Ragione Sociale"> 
			    <br>
			    <label for="partitaIva">Partita IVA</label>
			    <input id="partitaIva" type="text" name="partitaIva" placeholder="Partita IVA"> 
			    <br>
			    <label for="citta">Citt� della Sede Legale</label>
			    <input id="citta" type="text" name="citta" placeholder="Citt�"> 
			    <br>
			    <label for="indirizzo">Indirizzo Sede Legale</label>
			    <input id="indirizzo" type="text" name="indirizzo" placeholder="Indirizzo"> 
			    <br>
			    <label for="cap">CAP</label>
			    <input id="cap" type="text" name="cap" placeholder="CAP"> 
			    <br>
			    <label for="telefono">Recapito Telefonico</label>
			    <input id="telefono" type="text" name="telefono" placeholder="Recapito Telefonico" required> 
			    <br>
			    <label for="email">Email</label>
			    <input id="email" type="text" name="email" placeholder="Email"> 
			    <br>
			    <label for="password">Password</label>
			    <input id="password" type="password" name="password" placeholder="Password"> 
			    <br>
			    <input type="submit" value="Registrami"/>
			    <input type="reset" value="Reset"/>
			</fieldset>
		</form>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>