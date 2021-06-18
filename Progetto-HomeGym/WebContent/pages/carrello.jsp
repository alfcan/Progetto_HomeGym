<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>

<%
	Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
	ArrayList<ProductBean> products = null;
	if(carrello != null)	
		products = carrello.getProducts();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Carrello</title>
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/carello.css"%>">
    	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>	
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<div class="container dark-grey-text">
      	<div class="row wow fadeIn">
        <div class="col-md-8 mb-4 div1">
        
		<div class="card" id="carta">
		<table class="table table-hover shopping-cart-wrap">
			<%
				if(products != null && products.size() != 0){
			%>
			<thead class="text-muted">
			<tr id="intestazione">
				<th scope="col">Prodotto</th>
				<th scope="col">Prezzo</th>
				<th scope="col">Iva</th>
				<th scope="col">Quantita'</th>
			</tr>
			</thead>
			<%
					for(ProductBean product : products){
			%>
			<tbody>
				<tr id="figura">
					<td>
						<figure class="media">
						<div class="img-wrap"><img src="<%=request.getContextPath()+ "/" + product.getUrlImmagine()%>" width="80" height="80" class="img-thumbnail img-sm" id="fotoprodotto"></div>
						<figcaption class="media-body">
                                   <dl class="dlist-inline small">   
									<dd><%=product.getNome()%></dd>
									</dl>
                        </figcaption>
						</figure> 
					</td>
					
					<td>&euro;<%=product.getPrezzo()%></td>
					<td><%=product.getIva()%></td>
					<td><%=product.getQtaCarrello()%></td>
					<td>
						
						<a href="/Progetto-HomeGym/ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>"><img src="foto/piu.png" class="btn btn-danger btn-lg float-right" id="aggiungi"></a><br>
						<a href="/Progetto-HomeGym/ProductControl?action=RemoveToCarrello&codice=<%=product.getCodice()%>"><img src="foto/meno.png" class="btn btn-danger btn-lg float-right" id="rimuovi"></a><br>
						<a href="/Progetto-HomeGym/ProductControl?action=DeleteToCarrello&codice=<%=product.getCodice()%>"><img src="foto/rimuovi.png" class="btn btn-danger btn-lg float-right" id="elimina"></a><br>
						
					</td>
				</tr>
			</tbody>
			
		</table>
		</div>
			<% 
				}}else{
			%>
			
			<br>
       		<h6>Nessun elemento aggiunto al carrello fino ad ora.</h6>
       		<br>
       		
       		
			<%
				}
			%>
		
		<%if(carrello != null && carrello.getTotale()!=0){ %>
		
		<div class="col-md-4 mb-4">
        
                <br> <br>
				<h5>TOTALE: &euro;<%=carrello.getTotale() %></h5>
				<a href="/Progetto-HomeGym/OrdineControl?action=datiOrdineUtente"><button class="btn btn-lg btn-primary btn-block btn-dark" id="bottoneAcquisto">Acquista</button></a>
				</div>
    			</div>
		</div>
			<%}%>
				
       
		</div>
		</div>
		</div>
		
		
		
		<%@ include file="../fragments/footer.jsp" %>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>	
	</body>
	
</html>
