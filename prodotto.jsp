<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*, it.unisa.model.DAOS.*" %>

<%
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
%>

<!DOCTYPE html>
<html>
<head>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - <%=prodotto.getNome()%></title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		<h1><%=prodotto.getNome()%></h1>
		<h1>Prezzo: <%=prodotto.getPrezzo()%></h1>
		<p><%=prodotto.getDescrizione()%></p>
		<a href="ProductControl?action=AddToCarrello&codice=<%=prodotto.getCodice()%>">Aggiungi al carrello</a>
		<%@ include file="../fragments/footer.jsp" %>	
	</body>
</html>