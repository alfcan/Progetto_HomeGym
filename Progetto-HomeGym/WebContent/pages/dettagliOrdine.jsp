<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("dettagliOrdine");
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Dettaglio Ordine</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		<h1>Dettaglio Ordine</h1>
		<table>
			<%
				if(products != null && products.size() != 0){
					for(ProductBean product : products){
			%>
			<tr>
				<th>Codice</th>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Iva</th>
			</tr>
			<tr>
				<th><%=product.getCodice()%></th>
				<th><%=product.getNome()%></th>
				<th><%=product.getPrezzo()%></th>
				<th><%=product.getIva()%></th>
			</tr>
			<%
					}
				}
			%>
		</table>
		
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>