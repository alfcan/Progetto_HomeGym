<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.beans.*, it.unisa.model.DAOS.*" %>

<%
	ProductBean prodotto = (ProductBean) request.getAttribute("prodotto");
	ArrayList<FeedbackBean> feedbacks = (ArrayList<FeedbackBean>) request.getAttribute("feedbacks");
%>

<!DOCTYPE html>
<html>
<head>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - <%=prodotto.getNome()%></title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<h1><%=prodotto.getNome()%></h1>
		<img src="<%=prodotto.getUrlImmagine()%>" width="500" height="600">	
		<h1>Prezzo: <%=prodotto.getPrezzo()%></h1>
		<p><%=prodotto.getDescrizione()%></p>
		
		<%if(prodotto.getQtaMagazzino() > 0) {%>
			<a href="ProductControl?action=AddToCarrello&codice=<%=prodotto.getCodice()%>">Aggiungi al carrello</a>
		<%} else { %>
			Non disponibile
		<%} %>
		
		<hr>
		<%if(feedbacks != null && feedbacks.size() != 0) {%>
			<h6>Recensioni</h6>
			<table>
				<thead>
					<tr>
					<th>Valutazione</th>
					<th>Commento</th>
					</tr>
				</thead>
				<tbody>
				<%for(FeedbackBean f : feedbacks){ %>
					<tr>
					<td><%=f.getValutazione() %></td>
					<td><%=f.getCommento() %></td>
					</tr>
				<%} %>
				</tbody>
			</table>
		<%} else {%>
			<h6>Nessuna recensione per questo prodotto.</h6>
		<%} %>
		
		<%@ include file="../fragments/footer.jsp" %>	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>