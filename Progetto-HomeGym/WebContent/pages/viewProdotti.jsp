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
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/catalogo.css"%>">
<meta charset="ISO-8859-1">
<title>HomeGym - Catalogo</title>
</head>
<body>
<%@ include file="../fragments/header.jsp" %>
<div class="container bootstrap snipets">
   <h1  style="text-align: center;color: #FA9600;font-family:Verdana;">Catalogo</h1>
    <div class="container">
		<div class="row">
   <%
				if(products != null && products.size() != 0){
			
					for(ProductBean product : products){
	%>
	<div class = "col-md-4" id="cardColumn">
   <div class="row flow-offset-1">
     <div class="col-xs-6 col-md-4">
       <div class="product tumbnail thumbnail-3"><a href="ProductControl?action=ViewProdotto&codice=<%=product.getCodice()%>">
       <img src="<%=request.getContextPath() + "/" + product.getUrlImmagine()%>" width="130" height="130"></a>
         <div class="caption">
           <h6><a href="#"><%=product.getNome()%></a></h6><span class="price">
             <p><%=product.getPrezzo()%></p>
             <% if(product.getQtaMagazzino() == 0) {%>
					Non Disponibile
				<%}else { %>
					<div class="card-bottom">
					<a href="ProductControl?action=AddToCarrello&codice=<%=product.getCodice()%>" class="btn btn-danger btn-lg float-right btn-mio">Aggiungi al carello</a>
					</div>
				<%} %>
			
			<%
					}
			%>
			
			<%
				}
			%>
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