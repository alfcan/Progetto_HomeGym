<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("dettagliOrdine");
	UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
			<title>HomeGym - Amministratore</title>
		<%} else {%>
			<title>HomeGym - Dettaglio Ordine</title>
		<%} %>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
				<div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Dettagli Ordine</h3>
                            </div>
                            <div class="card-body">
		
			<%
				if(products != null && products.size() != 0){
			%>
			<h6 id="testo">Indirizzo spedizione: <%=request.getAttribute("indirizzo")%></h6>
			<table>
				<tr>
					<th></th>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Iva</th>
					<th>Quantità</th>
				</tr>
			<%
					for(ProductBean product : products){
			%>
				<tr>
					<td><img src="<%=product.getUrlImmagine()%>" width="80" height="80"></td>
					<td><%=product.getNome()%></td>
					<td><%=product.getPrezzo()%></td>
					<td><%=product.getIva()%></td>
					<td><%=product.getQtaCarrello()%></td>
				</tr>
			<%
					}
			%>
			</table>
			<%
				}
			%>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>