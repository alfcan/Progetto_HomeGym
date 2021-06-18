<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	String action = request.getParameter("action");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/header.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/footer.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/css/bootstrap.min.css" %>>
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script> 
	
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body onload="riempi()">
		<%@ include file="/fragments/header.jsp" %>
		
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                        
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Aggiungi prodotto</h3>
                            </div>
                         <div class="card-body">
		
		<form method="post" action="/Progetto-HomeGym/AdminControl">
			<input type="hidden" name="action" value="aggiungiProdotto">
			<div class="form-group">
				<label class="grassetto" for="codice">Codice Prodotto</label>
				<input  class="form-control form-control-lg rounded-0 BORDO" type="text" id="codice" name="codice"><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="nome">Nome</label>
				<input class="form-control form-control-lg rounded-0 BORDO" type="text" id="nome" name="nome"><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="descrizione">Descrizione</label><br>
				<textarea class="form-control form-control-lg rounded-0 BORDO" id="descrizione" name="descrizione" rows="3" cols="50"></textarea><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="prezzo">Prezzo</label>
				<input class="form-control form-control-lg rounded-0 BORDO" type="number" id="prezzo" name="prezzo"><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="iva">Iva</label>
				<input class="form-control form-control-lg rounded-0 BORDO" type="number" id="iva" name="iva" min="4" max="22"><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="qtaMagazzino">Quantità Magazzino</label>
				<input class="form-control form-control-lg rounded-0 BORDO" type="number" id="qtaMagazzino" name="qtaMagazzino"><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="categoria">Categoria</label>
				<select class="form-control form-control-lg rounded-0 BORDO" id="categoria" name="categoria">
					<option value="1">Fitness</option>
					<option value="2">BodyBulding</option>
					<option value="3">Manubri</option>
					<option value="4">Accessori</option>
				</select><br>
			</div>
			<div class="form-group">
				<label class="grassetto" for="immagine">Immagine</label>	
				<input class="form-control form-control-lg rounded-0 BORDO" type="text" id="immagine" name="img" placeholder="Inserisci nome file"><br>
			</div>
			<button type="submit" class="btn btn-danger btn-lg float-right btn-mio">Aggiungi il prodotto</button>
		</form>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>

		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>