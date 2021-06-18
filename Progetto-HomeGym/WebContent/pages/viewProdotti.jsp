<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("prodotti");
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/catalogo.css"%>">
	<meta charset="ISO-8859-1">
	<title>HomeGym - Catalogo</title>
</head>
<body>
	<%@ include file="../fragments/header.jsp" %>
	<br>
	<div class="container bootstrap snipets">
	   	<div class="row flow-offset-1">
		    <%if(products != null && products.size() != 0){
				for(ProductBean product : products){%>
			<div class="col-xs-6 col-md-4">
				<div class="product tumbnail thumbnail-3"><a href="ProductControl?action=ViewProdotto&codice=<%=product.getCodice()%>"><img src="<%=request.getContextPath() + "/" + product.getUrlImmagine()%>"></a>
			    	<div class="caption">
				       	<h6><%=product.getNome()%></h6>
				        <span class="price"><p>&euro;<%=product.getPrezzo()%></p></span>
				        <% if(product.getQtaMagazzino() == 0) {%>
							<p class="float-right">Non Disponibile</p>
						<%}else { %>
							<a href="ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>" class="btn btn-danger float-right btn-mio">Aggiungi al carello</a>
						<%} %>
					</div>
				</div>
			</div>
				<%}%>
			<%}%>
		</div>
	</div>
		
	<%@ include file="../fragments/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>