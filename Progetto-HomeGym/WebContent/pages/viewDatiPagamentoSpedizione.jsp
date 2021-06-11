<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>

<%
	UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
	DatiPagamentoBean datiPagamento = (DatiPagamentoBean) request.getAttribute("datiPagamento");
	ArrayList<IndirizzoSpedizioneBean> indirizzi = (ArrayList<IndirizzoSpedizioneBean>) request.getAttribute("indirizzi");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Area Utente</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
    	<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<script src="../jsMiei/footer.js"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<h1>I tuoi Dati di Pagamento & Spedizione</h1>
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}%>
		
		<%if(datiPagamento.getNumeroCarta().equals("") || datiPagamento == null){ %>
			<form method="post" action="/Progetto-HomeGym/UtenteControl">
				<p> Inserisci dati pagamento</p>
				<input type="hidden" name="action" value="addDatiPagamento">
				
			 	<label for="carta">&nbspNumero Carta</label>
	            <input type="text" name="carta" id="carta" placeholder="Numero carta">
	            
	            <label for="cvv">&nbspCvv</label>
	            <input type="text" name="cvv" id="cvv" placeholder="Cvv">
	            
	            <label for="data">&nbspData scadenza</label>
	            <input type="date" name="data" id="data" placeholder="Data scadenza">
	            
	            <input type="submit" value="Invia">
			</form>
		<%} else {%>
			<h3>Dati Pagamento</h3>
			<p>
				Numero Carta: <%=datiPagamento.getNumeroCarta()%>
			</p>
			<form method="post" action="/Progetto-HomeGym/UtenteControl">
				<input type="hidden" name="action" value="rimuoviDatiPagamento">
				<input type="hidden" name="carta" value=<%=datiPagamento.getNumeroCarta()%>>
				<input type="submit" value="Rimuovi Metodo di Pagamento">
			</form>
		<%} %>
		
		<%if(!indirizzi.isEmpty()){ %>
			<hr>
			<h3>Indirizzi Spedizione</h3>
			<table>
				<thead>
					<tr>
						<th>Indirizzo</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<%for(IndirizzoSpedizioneBean indirizzo : indirizzi){%>
				<tbody>
					<tr>
						<td><%=indirizzo.getVia() + " "+ indirizzo.getCitta() + " "+ indirizzo.getCap()%></td>
						<td><a href="/Progetto-HomeGym/UtenteControl?action=rimuoviIndirizzoSpedizione&idIndirizzo=<%=indirizzo.getID()%>">Rimuovi</a></td>
					</tr>
				</tbody>
				<%}%>
			</table>		
		<%}%>
		
		<br><hr>
		<form method="post" action="/Progetto-HomeGym/UtenteControl">
			<p>Inserisci dati spedizione</p>
			<input type="hidden" name="action" value="addIndirizzoSpedizione">
			
		 	<label for="via">&nbspVia</label>
            <input type="text" name="via" id="via" placeholder="Via">
            
            <label for="citta">&nbspCittà</label>
            <input type="text" name="citta" id="citta" placeholder="Città">
            
            <label for="cap">&nbspCap</label>
            <input type="text" name="cap" id="cap" placeholder="Cap">
            
            <input type="submit" value="Invia">
		</form>		
	
	</body>
	
	<%@ include file="../fragments/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
</html>