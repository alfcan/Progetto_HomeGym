<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Checkout</title>
 		<link rel="stylesheet" href="../css/bootstrap.min.css">
    	<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<script src="../jsMiei/footer.js"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<% UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
			if(utente == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
				dispatcher.forward(request, response);
			}
			ArrayList<IndirizzoSpedizioneBean> indirizziSpedizione= (ArrayList<IndirizzoSpedizioneBean>)request.getAttribute("indirizziSpedizioni");
			DatiPagamentoBean datiPagamento=(DatiPagamentoBean) request.getAttribute("datiPagamento");
		%>
		
		<h1>Dati Spedizione & Dati Pagamento</h1>
		<%if(indirizziSpedizione!=null && datiPagamento!=null){%>
		<form action="/Progetto-HomeGym/OrdineControl">
			<input type="hidden" name="action" value="checkout"> 
			<p>Scegli l'indirizzo di spedizione</p>
			<%for(IndirizzoSpedizioneBean indirizzo: indirizziSpedizione){%>
				<label> <%=indirizzo.getVia() + " "+ indirizzo.getCitta() + " "+ indirizzo.getCap() %></label>
				<input type="radio" name="indirizzo" value=<%=indirizzo.getID()%>>
			<% } %>
			<input type="submit" value="Effettua ordine">
		</form>
		<%} %>
		
		<form>
			<p> Inserisci dati pagamento</p>
		 	<label>&nbspNumero Carta</label>
            <input type="text" name="carta" id="carta" placeholder="Numero carta">
            
            <label>&nbspCvv</label>
            <input type="text" name="cvv" id="cvv" placeholder="Cvv">
            
            <label>&nbspData scadenza</label>
            <input type="date" name="data" id="data" placeholder="Data scadenza">
            
            <input type="submit" value="Invia">
		</form>	
		
		<form>
			<p> Inserisci dati spedizione</p>
		 	<label>&nbspVia</label>
            <input type="text" name="via" id="via" placeholder="Via">
            
            <label>&nbspCittà</label>
            <input type="text" name="citta" id="citta" placeholder="Città">
            
            <label>&nbspCap</label>
            <input type="text" name="cap" id="cap" placeholder="Cap">
            
            <input type="submit" value="Invia">
		</form>
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>	

	</body>
</html>