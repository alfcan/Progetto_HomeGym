<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	UtenteBean utente = (UtenteBean) request.getSession().getAttribute("Utente");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Area Utente</title>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/areaUtente.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/footer.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/header.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/css/bootstrap.min.css" %>>
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
		
		<script src="../jsMiei/footer.js"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1 style="text-align: center;color: #FA9600;font-family:Verdana;">Benvenuto nella tua area utente</h1>
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}else if (utente.getTipo().equalsIgnoreCase("admin")){
		%>
			<ul>
				<li><a href="/Progetto-HomeGym/AdminControl?action=gestioneOrdini" class="lista">Gestione Ordini</a></li>
				<li><a href="/Progetto-HomeGym/AdminControl?action=gestioneCatalogo" class="lista">Gestione Catalogo</a></li>
				<li><a href="/Progetto-HomeGym/AdminControl?action=gestioneClienti" class="lista">I Tuoi Clienti</a></li>
			</ul>
		<%
		}else{
		%>
			<ul>
				<li><a href="/Progetto-HomeGym/OrdineControl?action=viewOrdini" class="lista">I miei ordini</a></li>
				<li><a href="/Progetto-HomeGym/UtenteControl?action=viewDatiPagamentoSpedizione" class="lista">Dati Pagamento & Spedizione</a></li>
				<li><a href="/Progetto-HomeGym/UtenteControl?action=viewDatiAnagrafica" class="lista">Dati Anagrafica</a></li>			
				<li><a href="/Progetto-HomeGym/UtenteControl?action=feedback" class="lista">FeedBack</a></li>
			</ul>
		<%
		}
		%>
	</body>
	
	<%@ include file="../fragments/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
</html>