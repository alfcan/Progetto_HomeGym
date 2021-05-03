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
				<th>Azioni</th>
			</tr>
			<tr>
				<th><%=product.getCodice()%></th>
				<th><%=product.getNome()%></th>
				<th><%=product.getPrezzo()%></th>
				<th><%=product.getIva()%></th>
				<th>
					<a href="ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>">Aggiungi un elemento</a>
					<a href="ProductControl?action=RemoveToCarrello&codice=<%=product.getCodice()%>">Rimuovi un elemento</a>
					<a href="ProductControl?action=DeleteToCarrello&codice=<%=product.getCodice()%>">Elimina elemento</a>
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
		
		<%@ include file="../fragments/footer.jsp" %>	
	</body>
</html>