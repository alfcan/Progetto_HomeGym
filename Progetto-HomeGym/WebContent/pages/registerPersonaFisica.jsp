<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>HomeGym - Registrazione</title>
</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>	
	
		<form action="/Progetto-HomeGym/RegistrazioneControl" method="post">
			<fieldset>
				<legend>Registrazione</legend>
				<input type="hidden" name="tipo" value="Persona Fisica">
				<label for="cognome">Cognome</label>
			    <input id="cognome" type="text" name="cognome" placeholder="Cognome" required> 
			    <br>
			    <label for="nome">Nome</label>
			    <input id="nome" type="text" name="nome" placeholder="Nome" required> 
			    <br>
			    <label>Genere</label><br>
			    <label for="uomo">Uomo</label>
			    <input id="uomo" type="radio" name="genere" value="Uomo"><br>
			    <label for="donna">Donna</label>
				<input type="radio" id="donna" name="genere" value="Donna"><br>
			    <br>
			    <label for="telefono">Recapito Telefonico</label>
			    <input id="telefono" type="text" name="telefono" placeholder="Recapito Telefonico" required> 
			    <br>
			    <label for="email">Email</label>
			    <input id="email" type="text" name="email" placeholder="Email" required> 
			    <br>
			    <label for="password">Password</label>
			    <input id="password" type="password" name="password" placeholder="Password" required> 
			    <br>
			    <input type="submit" value="Registrami"/>
			    <input type="reset" value="Reset"/>
			</fieldset>
		</form>
		
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>