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
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/prodotto.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
		<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - <%=prodotto.getNome()%></title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<h1 style="padding-left:20px;"><%=prodotto.getNome()%></h1>
		<img src="<%=prodotto.getUrlImmagine()%>" width="500" height="600" id="foto">	
		<h1>Prezzo: <%=prodotto.getPrezzo()%></h1>
		<p style="padding-left:1px;"><%=prodotto.getDescrizione()%></p>
		
		<%if(prodotto.getQtaMagazzino() > 0) {%>
			<a href="ProductControl?action=AddToCarrello&codice=<%=prodotto.getCodice()%>" class="btn btn-danger btn-lg float-right btn-mio">Aggiungi al carrello</a>
		<%} else { %>
			Non disponibile
		<%} %>
		
		<hr>
		
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
                    
		<%if(feedbacks != null && feedbacks.size() != 0) {%>
			<div class="card rounded-0 CDtot" id="contenitoreTotale">
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
			</div>
			</div>
			</div>
			</div>
			
		<%} else {%>
			<h6 class="testo">Nessuna recensione per questo prodotto.</h6>
		<%} %>
		
		<%@ include file="../fragments/footer.jsp" %>	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>