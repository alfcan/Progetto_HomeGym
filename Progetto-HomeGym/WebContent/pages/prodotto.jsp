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
	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/prodotto.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
		
		<meta charset="ISO-8859-1">
		<title>HomeGym - <%=prodotto.getNome()%></title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		
		<img src="<%=prodotto.getUrlImmagine()%>" width="500" height="600" style="float:left; margin:0px 20px 20px 0px;">	
		<h1 style="padding-top:30px;"><%=prodotto.getNome()%></h1>
		<p style="padding-top:20px;"><%=prodotto.getDescrizione()%></p>
		<h1 id="grassetto"> &euro;<%=prodotto.getPrezzo()%></h1>
		
		<%if(prodotto.getQtaMagazzino() > 0) {%>
			<a href="ProductControl?action=AddToCarrello&codice=<%=prodotto.getCodice()%>" class="btn btn-danger btn-lg float-right btn-mio">Aggiungi al carrello</a>
		<%} else { %>
			Non disponibile
		<%} %>
		
		
		<div style="clear:left;" class="feedback">
		<%if(feedbacks != null && feedbacks.size() != 0) {%>
		<div class="container py-5">
			<div class="card rounded-0 CDtot" >
            <div class="card-header carta1">
                 <h3 class="mb-0">Recensioni</h3>
             </div>
             <div class="card-body">
        
  
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
			
			</div>
			</div>
			</div>
		
		<br>
		<br>
		<br>
		<%} else {%>
			<h6 class="testo">Nessuna recensione per questo prodotto.</h6>
		<%} %>
		<br>
		<br>
		<br>
		
		<%@ include file="../fragments/footer.jsp" %>	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>