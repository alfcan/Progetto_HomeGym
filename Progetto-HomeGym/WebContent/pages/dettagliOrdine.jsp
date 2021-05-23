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
		<meta charset="ISO-8859-1">
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
			<title>HomeGym - Amministratore</title>
		<%} else {%>
			<title>HomeGym - Dettaglio Ordine</title>
		<%} %>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		
		<h1>Dettaglio Ordine</h1>
		
			<%
				if(products != null && products.size() != 0){
			%>
			<table>
				<tr>
					<th></th>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Iva</th>
					<th>Quantità</th>
				</tr>
			<%
					for(ProductBean product : products){
			%>
				<tr>
					<td><img src="<%=product.getUrlImmagine()%>" width="80" height="80"></td>
					<td><%=product.getNome()%></td>
					<td><%=product.getPrezzo()%></td>
					<td><%=product.getIva()%></td>
					<td><%=product.getQtaCarrello()%></td>
				</tr>
			<%
					}
			%>
			</table>
			<%
				}
			%>
		
		
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>