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
		<title>HomeGym - Carrello</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		<h1>Carrello</h1>
		<table>
			<%
				if(prodotti != null && prodotti.size() != 0){
					for(ProductBean product : prodotti){
			%>
			<tr>
				<th>Codice</th>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Iva</th>
				<th>Quantità</th>
				<th>Azioni</th>
			</tr>
			<tr>
				<th><%=product.getCodice()%></th>
				<th><%=product.getNome()%></th>
				<th><%=product.getPrezzo()%></th>
				<th><%=product.getIva()%></th>
				<th><%=product.getQtaCarello()%></th>
				<th>
					<a href="/Progetto-HomeGym/ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>">Aggiungi un elemento</a><br>
					<a href="/Progetto-HomeGym/ProductControl?action=RemoveToCarrello&codice=<%=product.getCodice()%>">Rimuovi un elemento</a><br>
					<a href="/Progetto-HomeGym/ProductControl?action=DeleteToCarrello&codice=<%=product.getCodice()%>">Elimina elemento</a><br>
				</th>
			<tr>
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
	</body>
</html>