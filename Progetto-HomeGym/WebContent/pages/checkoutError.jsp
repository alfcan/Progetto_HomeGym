<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>

<%
	Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
	ArrayList<ProductBean> prodotti = null;
	if(carrello != null)	
		prodotti = carrello.getProducts();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Pagina di Errore</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		
		<h1>Il tuo carrello è vuoto, prima di effettuare il checkout aggiungi i toui prodotti al carrello.</h1>
		
		<%@ include file="../fragments/footer.jsp" %>	
	</body>
</html>