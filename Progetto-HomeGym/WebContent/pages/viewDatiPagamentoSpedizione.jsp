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
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">	
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<script src="Progetto-HomeGym/jsMiei/footer.js"></script>
		<script src="Progetto-HomeGym/jsMiei/controlliDatiPagamento.js">></script> 
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<h1 style="text-align: center;color: #FA9600;font-family:Verdana;">I tuoi Dati di Pagamento & Spedizione</h1>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}%>
		
		<%if(datiPagamento.getNumeroCarta().equals("") || datiPagamento == null){ %>
		
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Inserisci dati pagamento</h3>
                            </div>
                            <div class="card-body">
                         
				<form method="post" action="/Progetto-HomeGym/UtenteControl" onsubmit="return checkDatiPag(this)">
				
				<input type="hidden" name="action" value="addDatiPagamento">
				
			 	<label class="grassetto" for="carta"><img src="foto/partitaiva.png">&nbspNumero Carta</label>
	            <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="carta" id="carta" placeholder="Numero carta"><br>
	            <p id="errorNumCarta"></p>
	            
	            <label class="grassetto" for="cvv"><img src="foto/partitaiva.png">&nbspCvv</label>
	            <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="cvv" id="cvv" placeholder="Cvv"><br>
	            <p id="errorCVV"></p>
	            
	            <label class="grassetto"for="data"><img src="foto/calendario.png">&nbspData scadenza</label>
	            <input type="date" class="form-control form-control-lg rounded-0 BORDO" name="data" id="data" placeholder="Data scadenza"><br>
	            <p id="errorData"></p>
	            
	            <input type="submit" class="btn btn-danger btn-lg float-right btn-mio" value="Invia">
			</form>
			</div>
			</div>
		<%} else {%>
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
         <div class="card-header carta1">
           <h3 class="mb-0">Dati Pagamento</h3>
          </div>
           <div class="card-body">
             
			<p>
				Numero Carta: <%=datiPagamento.getNumeroCarta()%>
			</p>
			<form method="post" action="/Progetto-HomeGym/UtenteControl">
				<input type="hidden" name="action" value="rimuoviDatiPagamento">
				<input type="hidden" name="carta" value=<%=datiPagamento.getNumeroCarta()%>>
				<input type="submit" class="btn btn-danger btn-lg float-right btn-mio" value="Rimuovi">
			</form>
			</div>
			</div>
			<br>
		<%} %>
		
		<%if(!indirizzi.isEmpty()){ %>
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
         <div class="card-header carta1">
           <h3 class="mb-0">Indirizzo Spedizione</h3>
          </div>
           <div class="card-body">
            <p id="error">
		    </p> 			
			<table>
				<thead>
					<tr>
						<th>Indirizzo</th>
					</tr>
				</thead>
				<%for(IndirizzoSpedizioneBean indirizzo : indirizzi){%>
				<tbody>
					<tr>
						<td><%=indirizzo.getVia() + " "+ indirizzo.getCitta() + " "+ indirizzo.getCap()%></td>
						<td><a href="/Progetto-HomeGym/UtenteControl?action=rimuoviIndirizzoSpedizione&idIndirizzo=<%=indirizzo.getID()%>" class="btn btn-danger btn-lg float-right btn-mio">Rimuovi</a></td>
					</tr>
				</tbody>
				<%}%>
			</table>		
		<%}%>
		<br>
		
		<form method="post" action="/Progetto-HomeGym/UtenteControl">
			<div class="card rounded-0 CDtot" id="contenitoreTotale">
             <div class="card-header carta1">
               <h3 class="mb-0">Inserisci dati spedizione</h3>
             </div><br>
               <div class="card-body">
               <p id="error">
		       </p> 
            
			<input type="hidden" name="action" value="addIndirizzoSpedizione">
			
		 	<label class="grassetto" for="via"><img src="foto/luogo.png">&nbspVia</label>
            <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="via" id="via" placeholder="Via"><br>
            
            <label class="grassetto" for="citta"><img src="foto/luogo.png">&nbspCittà</label>
            <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="citta" id="citta" placeholder="Città"><br>
            
            <label class="grassetto" for="cap"><img src="foto/luogo.png">&nbspCap</label>
            <input type="text" class="form-control form-control-lg rounded-0 BORDO" name="cap" id="cap" placeholder="Cap"><br>
            
            <input type="submit" class="btn btn-danger btn-lg float-right btn-mio" value="Invia">
		</form>	
		</div>
		</div>	
	
	</body>
	
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
</html>