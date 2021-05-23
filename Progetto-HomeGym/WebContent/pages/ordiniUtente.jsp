<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("dettagliOrdine");
	UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
			<title>HomeGym - Amministratore</title>
		<%} else {%>
			<title>HomeGym - Ordini</title>
		<%} %>
	</head>
	<body>
	
		<%@ include file="../fragments/header.jsp" %>
		
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
			<h1>Ordini dell'utente selezionato</h1>
		<%} else {%>
			<h1>I tuoi ordini</h1>
		<%} %>
		<% 
			ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");
			if(ordini != null && ordini.size() != 0){
		%>	
		<table>
			<tr>
				<th>ID Ordine</th>
				<th>Stato</th>
				<th>Data</th>
				<th>Indirizzo Spedizione</th>
				<th>Totale</th>
			</tr>
			<%for(OrdineBean ordine : ordini){ %>
				<tr>
					<th><%=ordine.getID()%></th>
					<th><%=ordine.getStato()%></th>
					<th><%=ordine.getData()%></th>
					<th><%=ordine.getIndirizzoSpedizione()%></th>
					<th><%=ordine.getTotale()%></th>
					<th>
						<a href="OrdineControl?action=dettagliOrdine&id=<%=ordine.getID()%>">Dettagli</a>
					</th>
				<tr>		
			<%	}
			%>
			</table>
			<%
			} else { 
				if(utente.getTipo().equalsIgnoreCase("admin")) {%>
					<h3>Non ha effettuato ordini</h3>
				<%} else {%>
					<h3>Non hai effettuato ordini</h3>
				<%} %>
			<%} %>
			
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>