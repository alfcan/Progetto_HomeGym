<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	UtenteBean utente = (UtenteBean) request.getSession().getAttribute("Utente");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Dati Anagrafici</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
    	<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<script src="../jsMiei/footer.js"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1>I tuoi dati anagrafici</h1>
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}else if (utente.getTipo().equalsIgnoreCase("persona fisica")){
			PersonaFisicaBean p = (PersonaFisicaBean)request.getAttribute("anagrafica");
		%>
			<h5>Cognome</h5>
			<p><%=p.getCognome()%></p>
			<h5>Nome</h5>
			<p><%=p.getNome()%></p>
			<h5>Genere</h5>
			<p><%=p.getGenere()%></p>
			<h5>Telefono</h5>
			<p><%=p.getNumeroTelefono()%></p>
			<h5>Email</h5>
			<p><%=p.getEmail()%></p>
		<%
		}else{
			AziendaBean a = (AziendaBean)request.getAttribute("anagrafica");
		%>
			<h5>Ragione Sociale</h5>
			<p><%=a.getRagioneSociale()%></p>
			<h5>Partita IVA</h5>
			<p><%=a.getPartitaIva()%></p>
			<h5>Città Sede Legale</h5>
			<p><%=a.getCitta()%></p>
			<h5>Indirizzo Sede Legale</h5>
			<p><%=a.getIndirizzoSedeLegale()%></p>
			<h5>Telefono</h5>
			<p><%=a.getNumeroTelefono()%></p>
			<h5>Email</h5>
			<p><%=a.getEmail()%></p>
		<%}%>
	</body>
	
	<%@ include file="../fragments/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
</html>