<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Checkout</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
    	<link rel="stylesheet" href="../Stili/header.css">
		<link rel="stylesheet" href="../Stili/footer.css">
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
		<script src="../jsMiei/footer.js"></script>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<% UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
			if(utente == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
				dispatcher.forward(request, response);
			}
			ArrayList<IndirizzoSpedizioneBean> indirizziSpedizione= (ArrayList<IndirizzoSpedizioneBean>)request.getAttribute("indirizziSpedizione");
			DatiPagamentoBean datiPagamento=(DatiPagamentoBean) request.getAttribute("datiPagamento");
		%>
		
		<h1 style="text-align: center;color: #FA9600;font-family:Verdana;">Dati Spedizione & Dati Pagamento</h1>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
		<%if(indirizziSpedizione.isEmpty() || datiPagamento.getNumeroCarta().equals("")){%>
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Inserisci i dati di pagamento e spedizione prima di procedere al checkout</h3>
                            </div>
                            <div class="card-body">
                        
			<p>Come fare? <a href="pages/areaUtente.jsp" id="linkReg">Vai nell'area utente</a> nella sezione "Dati Pagamento & Spedizione"</p>
			</div>
			</div>
			
		<%} else {%>
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
         <div class="card-header carta1">
           <h3 class="mb-0">Scegli l'indirizzo di spedizione</h3>
          </div>
           <div class="card-body">
            
			<form action="/Progetto-HomeGym/OrdineControl">
				<input type="hidden" name="action" value="checkout"> 
				<%for(IndirizzoSpedizioneBean indirizzo: indirizziSpedizione){%>
					<label> <%=indirizzo.getVia() + " "+ indirizzo.getCitta() + " "+ indirizzo.getCap() %></label>
					<input type="radio" name="indirizzo" value=<%=indirizzo.getID()%> required><br>
				<% } %>
				<input type="submit" class="btn btn-danger btn-lg float-right btn-mio" value="Effettua ordine">
			</form>
			<br><br>
			<h3>Il pagamento verrà effettuato sulla carta da voi registrata</h3>
		<%} %>
		</div>
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