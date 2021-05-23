<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	String action = request.getParameter("action");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body onload="riempi()">
		<%@ include file="/fragments/header.jsp" %>
		
		<h1>Aggiungi Prodotto</h1>
		
		<form method="post" action="/Progetto-HomeGym/AdminControl">
			<input type="hidden" name="action" value="aggiungiProdotto">
			<label for="codice">Codice Prodotto</label>
			<input type="text" id="codice" name="codice"><br>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="nome"><br>
			<label for="descrizione">Descrizione</label><br>
			<textarea id="descrizione" name="descrizione" rows="3" cols="50"></textarea><br>
			<label for="prezzo">Prezzo</label>
			<input type="number" id="prezzo" name="prezzo"><br>
			<label for="iva">Iva</label>
			<input type="number" id="iva" name="iva" min="4" max="22"><br>
			<label for="qtaMagazzino">Quantità Magazzino</label>
			<input type="number" id="qtaMagazzino" name="qtaMagazzino"><br>
			<label for="categoria">Categoria</label>
			<select id="categoria" name="categoria">
				<option value="1">Fitness</option>
				<option value="2">BodyBulding</option>
				<option value="3">Manubri</option>
				<option value="4">Accessori</option>
			</select><br>
			<label for="immagine">Immagine</label>	
			<input type="text" id="immagine" name="img" placeholder="Inserisci nome file"><br>
			<button type="submit">Aggiungi il prodotto</button>
		</form>

		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>