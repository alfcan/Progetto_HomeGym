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
		<title>HomeGym - Dati Anagrafici</title>
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		
		<h1 style="text-align: center;color: #FA9600;font-family:Verdana;">I tuoi dati anagrafici</h1>
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}else if (utente.getTipo().equalsIgnoreCase("persona fisica")){
			PersonaFisicaBean p = (PersonaFisicaBean)request.getAttribute("anagrafica");
		%>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
                    
                    <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-body">
			<h5 class="grassetto"><img src="foto/ominologin.PNG">Cognome</h5>
			<p><%=p.getCognome()%></p>
			<h5 class="grassetto"><img src="foto/ominologin.PNG">Nome</h5>
			<p><%=p.getNome()%></p>
			<h5 class="grassetto"><img src="foto/genere.jpg">Genere</h5>
			<p><%=p.getGenere()%></p>
			<h5 class="grassetto"><img src="foto/phone.png">Telefono</h5>
			<p><%=p.getNumeroTelefono()%></p>
			<h5 class="grassetto"><img src="foto/email.png">Email</h5>
			<p><%=p.getEmail()%></p>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<%
		
		}else{
			AziendaBean a = (AziendaBean)request.getAttribute("anagrafica");
		%>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
                    
                    <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-body">
			<h5 class="grassetto"><img src="foto/edificio.png">Ragione Sociale</h5>
			<p><%=a.getRagioneSociale()%></p>
			<h5 class="grassetto"><img src="foto/partitaiva.png">Partita IVA</h5>
			<p><%=a.getPartitaIva()%></p>
			<h5 class="grassetto"><img src="foto/luogo.png">Città Sede Legale</h5>
			<p><%=a.getCitta()%></p>
			<h5 class="grassetto"><img src="foto/luogo.png">Indirizzo Sede Legale</h5>
			<p><%=a.getIndirizzoSedeLegale()%></p>
			<h5 class="grassetto"><img src="foto/phone.png">Telefono</h5>
			<p><%=a.getNumeroTelefono()%></p>
			<h5 class="grassetto"><img src="foto/email.png">Email</h5>
			<p><%=a.getEmail()%></p>
			
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<%}%>
	</body>
	
	<%@ include file="../fragments/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
</html>