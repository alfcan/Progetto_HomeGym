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
		<meta charset="ISO-8859-1">
		<title>HomeGym - Catalogo</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		<table>
			<tr>
				<th>Codice</th>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Iva</th>
				<th>Azioni</th>
			</tr>
			<%
				if(products != null && products.size() != 0){
					for(ProductBean product : products){
			%>
			<tr>
				<th><%=product.getCodice()%></th>
				<th><%=product.getNome()%></th>
				<th><%=product.getPrezzo()%></th>
				<th><%=product.getIva()%></th>
				<th>
					<a href="ProductControl?action=ViewProdotto&codice=<%=product.getCodice()%>">Dettagli</a><br>
					<a href="ProductControll?action=AddToCarrello&codice=<%=product.getCodice()%>">Aggiungi al carello</a>
				</th>
			<tr>
			<%
					}
				}else{
			%>
			<tr>Non ci sono prodotti</tr>
			<%
				}
			%>
		</table>
		
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>