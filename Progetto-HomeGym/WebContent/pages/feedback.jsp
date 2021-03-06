<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.beans.*" %>

<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("prodottiBuy");
	UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="icon" href="foto/logofavicon.png" sizes="9x9">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
		<meta charset="ISO-8859-1">
		<title>HomeGym - FeedBack</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		                        	
		<%if(utente == null){	
				response.sendRedirect("login.jsp");
		}
		%>
			
			
			
		<%if(products != null && products.size() != 0){%>
		<div class="container py-5">
			<div class="row">
            	<div class="col-md-12">  
            		<div class="card rounded-0 CDtot" id="contenitoreTotale">
	                    <div class="card-header carta1"><h3 class="mb-0">Lasciaci un FeedBack sui prodotti che hai acquistato</h3></div>
    	                	<div class="card-body">          
								<table>
							       	<thead>
										<tr>
											<th>Prodotto</th>
											<th>Nome</th>
										</tr>
									</thead>
									<tbody>
										<%
												for(ProductBean product : products){
										%>
										<tr>
											<td><img src="<%=request.getContextPath() + "/" + product.getUrlImmagine()%>" width="80" height="80"></td>
											<td><%=product.getNome()%></td>
											<td>
												<form method="post" action="<%=request.getContextPath() + "/UtenteControl"%>">
													<input type="hidden" name="action" value="valutazione">
													<input type="hidden" name="utente" value="<%=utente.getEmail()%>">
													<input type="hidden" name="prodotto" value="<%=product.getCodice()%>">
													<label for="val">Valutazione: </label>
													<input type="number" id="val "name="val" min="0" max="5"><br>
													<label for="commento">Commento</label>
													<textarea rows="4" cols="35" id="commento" name="commento"></textarea><br>
													<input type="submit" class="btn btn-danger btn-lg float-right btn-mio" value="Invia">
												</form>
											</td>
										<tr>
											<%}%>
									</tbody>
								</table>
							</div>
						</div>	
					</div>
				</div>
			</div>
			
			<%}else{%>
				<div style="align:center; margin:5%">
					<h3>Feedback</h3>
					<h5>Non hai acquistato nessun prodotto.</h5>
					<h6>Visita prima il nostro shop.</h6>
				</div>
			<%}%>
			
			<%@ include file="../fragments/footer.jsp" %>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    	<script src="js/bootstrap.min.js"></script>
		</body>
</html>