<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("prodottiBuy");
	UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - FeedBack</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1>Lasciaci un FeedBack sui prodotti che hai acquistato</h1>
		<%
			if(utente == null){	
				response.sendRedirect("login.jsp");
			}
		%>
		<table>
			<%
				if(products != null && products.size() != 0){
			%>
			<thead>
			<tr>
				<th>Prodotto</th>
				<th>Nome</th>
			</tr>
			</thead>
			<tbody>
			<%
					for(ProductBean product : products){
			%>
			<tr>
				<td><img src="<%=request.getContextPath() + "/" + product.getUrlImmagine()%>" width="80" height="80"></td>
				<td><%=product.getNome()%></td>
				<td>
					<form method="post" action="<%=request.getContextPath() + "/UtenteControl"%>">
						<input type="hidden" name="action" value="valutazione">
						<input type="hidden" name="utente" value="<%=utente.getEmail()%>">
						<input type="hidden" name="prodotto" value="<%=product.getCodice()%>">
						<label for="val">Valutazione: </label>
						<input type="number" id="val "name="val" min="0" max="5"><br>
						<label for="commento">Commento</label>
						<textarea rows="4" cols="35" id="commento" name="commento"></textarea><br>
						<input type="submit" value="Invia">
					</form>
				</td>
			<tr>
				<%}%>
			</tbody>
		</table>
		<%}else{%>
			<br>
			<h5>Non hai acquistato nessun prodotto.</h5>
			<h6>Visita prima il nostro shop.</h6>
		<%}%>
	
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>