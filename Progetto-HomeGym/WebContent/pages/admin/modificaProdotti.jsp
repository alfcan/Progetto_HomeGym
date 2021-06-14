<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	String action = request.getParameter("action");
	String codice = request.getParameter("codice");
	String nome = request.getParameter("nome");
	String descrizione = request.getParameter("descrizione");
	String prezzo = request.getParameter("prezzo");
	String iva = request.getParameter("iva");
	String qtaMagazzino = request.getParameter("qtaMagazzino");
	String categoria = request.getParameter("categoria");
	String imgCompleta = request.getParameter("immagine");
	String img = "";
	img = imgCompleta.substring(imgCompleta.indexOf("/")+1);
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body>
		<%@ include file="/fragments/header.jsp" %>
		
		<h1>Modifica Prodotto</h1>
		
		<form method="post" action="/Progetto-HomeGym/AdminControl">
			<input type="hidden" name="action" value="modificaProdotto">
			<label for="codice">Codice Prodotto</label>
			<input type="text" id="codice" name="codice" value="<%=codice%>" readonly><br>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="nome" value="<%=nome%>"><br>
			<label for="descrizione">Descrizione</label><br>
			<textarea id="descrizione" name="descrizione" rows="3" cols="50"><%=descrizione%></textarea><br>
			<label for="prezzo">Prezzo</label>
			<input type="number" id="prezzo" name="prezzo" value="<%=prezzo%>"><br>
			<label for="iva">Iva</label>
			<input type="number" id="iva" name="iva" value="<%=iva%>"><br>
			<label for="qtaMagazzino">Quantità Magazzino</label>
			<input type="number" id="qtaMagazzino" name="qtaMagazzino" value="<%=qtaMagazzino%>"><br>
			<label for="categoria">Categoria</label>
			<select id="categoria" name="categoria">
				<%if(categoria.equals("1")){ %>
				<option value="1" selected>Fitness</option>
				<%}else{ %>
				<option value="1">Fitness</option>
				<%} if(categoria.equals("2")){ %>
				<option value="2" selected>BodyBulding</option>
				<%}else{ %>
				<option value="2">BodyBulding</option>
				<%} if(categoria.equals("3")){ %>
				<option value="3" selected>Manubri</option>
				<%}else{ %>
				<option value="3">Manubri</option>
				<%} if(categoria.equals("4")){ %>
				<<option value="4" selected>Accessori</option>
				<%}else{ %>
				<option value="4">Accessori</option>
				<%} %>
			</select><br>
			<label for="immagine">Immagine</label>	
			<input type="text" id="immagine" name="img" placeholder="Inserisci nome file" value="<%=img%>"><br>
			<button type="submit">Modifica il prodotto</button>
		</form>

		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>