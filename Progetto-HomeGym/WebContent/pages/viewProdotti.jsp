<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("prodotti");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - Catalogo</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1>Catalogo</h1>
		<table>
			<%
				if(products != null && products.size() != 0){
			%>
			<thead>
			<tr>
				<th>Immagine</th>
				<th>Codice</th>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Iva</th>
			</tr>
			</thead>
			<tbody>
			<%
					for(ProductBean product : products){
			%>
			<tr>
				<td><img src="<%=product.getUrlImmagine()%>" width="80" height="80"></td>
				<td><%=product.getCodice()%></td>
				<td><%=product.getNome()%></td>
				<td><%=product.getPrezzo()%></td>
				<td><%=product.getIva()%></td>
				<td>
				<a href="ProductControl?action=ViewProdotto&codice=<%=product.getCodice()%>">Dettagli</a><br>
				<% if(product.getQtaMagazzino() == 0) {%>
					Non Disponibile
				<%}else { %>
					<a href="ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>">Aggiungi al carello</a>
				<%} %>
				</td>
			<tr>
			<%
					}
			%>
			</tbody>
			<%
				}else{
			%>
			<tr>Non ci sono prodotti</tr>
			<%
				}
			%>
		</table>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>