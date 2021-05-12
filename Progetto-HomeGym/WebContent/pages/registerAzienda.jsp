<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Registrazione Azienda</title>
	</head>
	<body>
		<% request.setAttribute("tipo","Azienda"); %>
		<form action="../RegistrazioneControl" method="post">
			<fieldset>
				<legend>Registrazione azienda</legend>
				<label for="ragioneSociale">Ragione Sociale</label>
			    <input id="ragioneSociale" type="text" name="ragioneSociale" placeholder="Ragione Sociale"> 
			    <br>
			    <label for="partitaIva">Partita IVA</label>
			    <input id="partitaIva" type="text" name="partitaIva" placeholder="Partita IVA"> 
			    <br>
			    <label for="citta">Città della Sede Legale</label>
			    <input id="citta" type="text" name="citta" placeholder="Città"> 
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
	</body>
</html>