<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>

<%
	Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
	ArrayList<ProductBean> products = null;
	if(carrello != null)	
		products = carrello.getProducts();
%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - Carrello</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1>Carrello</h1>
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
				<th>Quantità</th>
			</tr>
			</thead>
			<%
					for(ProductBean product : products){
			%>
			<tbody>
				<tr>
					<td><img src="<%=product.getUrlImmagine()%>" width="80" height="80"></td>
					<td><%=product.getCodice()%></td>
					<td><%=product.getNome()%></td>
					<td><%=product.getPrezzo()%></td>
					<td><%=product.getIva()%></td>
					<td><%=product.getQtaCarrello()%></td>
					<td>
						<%if(product.getQtaMagazzino() >= 1){ %>
							<a href="/Progetto-HomeGym/ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>">Aggiungi un elemento</a><br>
						<%} else { %>
							Disponibile solo in queste quantità<br>
						<%} %>
						<a href="/Progetto-HomeGym/ProductControl?action=RemoveToCarrello&codice=<%=product.getCodice()%>">Rimuovi un elemento</a><br>
						<a href="/Progetto-HomeGym/ProductControl?action=DeleteToCarrello&codice=<%=product.getCodice()%>">Elimina elemento</a><br>
					</td>
				<tr>
			</tbody>
			<%
					}
				}else{
			%>
			<tr>Non ci sono prodotti nel carrello</tr>
			<%
				}
			%>
		</table>
		
		<%if(carrello != null && carrello.getTotale()!=0){ %>
			<h3>Totale: <%=carrello.getTotale()%></h3>
		<%}%>
		<br>
		<a href="/Progetto-HomeGym/OrdineControl?action=checkout">CheckOut</a>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>	
	</body>
</html>