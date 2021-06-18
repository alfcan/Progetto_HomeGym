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
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/carello.css"%>">
    	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script> 	
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>

		<div class="card">
			<div class="row">
	   			<%if(products != null && products.size() != 0){%>
				<div class="col-md-8 cart">
					<div class="title">
	                	<div class="row">
	                    	<div class="col">
	                        	<h4><b>Il tuo Carrello</b></h4>
	                    	</div>
	                    	<div class="col align-self-center text-right text-muted"><%=carrello.getQtaProducts()%> prodotti</div>
	                	</div>
	            	</div>
					<%for(ProductBean product : products){%>
						<div class="row border-top border-bottom">
							<div class="row main align-items-center">
								<div class="col-2"><img class="img-cart" src="<%=request.getContextPath()+ "/" + product.getUrlImmagine()%>"></div>
								<div class="col"><%=product.getNome()%></div>
								<div class="col"> <a href="/Progetto-HomeGym/ProductControl?action=RemoveToCarrello&codice=<%=product.getCodice()%>">-</a><%=product.getQtaCarrello()%><a href="/Progetto-HomeGym/ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>">+</a></div>
								<div class="col">&euro; <%=product.getPrezzo()%><span class="close"><a href="/Progetto-HomeGym/ProductControl?action=DeleteToCarrello&codice=<%=product.getCodice()%>">&#10005;</a></span></div>
							</div>
						</div>
					<%}%>
				</div>	
				<%}else{%>
					<div>
		       			<h6 id="not-product">Nessun elemento aggiunto al carrello fino ad ora.</h6>
					</div>
				<%}%>
	
			<%if(carrello != null && carrello.getTotale()!=0){ %>
				<div class="col-md-4 summary">
            		<div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
		                <div class="col">TOTALE</div>
		                <div class="col text-right">&euro; <%=carrello.getTotale() %></div>
		            </div> <a href="/Progetto-HomeGym/OrdineControl?action=datiOrdineUtente"><button class="btn btn-mio btn-lg btn-primary btn-block btn-dark">Acquista</button></a>
				</div>
			<%}%>
		</div>
	</div>

		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>	
	</body>
</html>