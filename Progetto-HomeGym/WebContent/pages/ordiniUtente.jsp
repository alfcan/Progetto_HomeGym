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
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
		<meta charset="ISO-8859-1">
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
			<title>HomeGym - Amministratore</title>
		<%} else {%>
			<title>HomeGym - Ordini</title>
		<%} %>
	</head>
	<body>
	
		<%@ include file="../fragments/header.jsp" %>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
		
		<%if(utente.getTipo().equalsIgnoreCase("admin")) {%>
		
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
                <div class="card-header carta1">
                   <h3 class="mb-0">Ordini dell'utente selezionato</h3>
                 </div>
         <div class="card-body">
			
		<%} else {%>

                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">I tuoi ordini</h3>
                            </div>
                            <div class="card-body">
			
		<%} %>
		<% 
			ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");
			if(ordini != null && ordini.size() != 0){
		%>	
		<table>
			<tr>
				<th>ID Ordine</th>
				<th>Stato</th>
				<th>Data</th>
				<th>Indirizzo Spedizione</th>
				<th>Totale</th>
			</tr>
			<%for(OrdineBean ordine : ordini){ %>
				<tr>
					<th><%=ordine.getID()%></th>
					<th><%=ordine.getStato()%></th>
					<th><%=ordine.getData()%></th>
					<th><%=ordine.getIndirizzoSpedizione()%></th>
					<th><%=ordine.getTotale()%></th>
					<th>
						<a href="OrdineControl?action=dettagliOrdine&id=<%=ordine.getID()%>" class="btn btn-danger btn-lg float-right btn-mio">Dettagli</a>
					</th>
				<tr>		
			<%	}
			%>
			</table>
			<%
			} else { 
				if(utente.getTipo().equalsIgnoreCase("admin")) {%>
					<h3>Non ha effettuato ordini</h3>
				<%} else {%>
					<h3>Non hai effettuato ordini</h3>
				<%} %>
			<%} %>
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