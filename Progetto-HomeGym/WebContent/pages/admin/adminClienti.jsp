<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">
	<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/registrazione.css"%>">
	<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/footer.css" %>>
	<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/header.css" %>>
	<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script> 
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body>
		<%@ include file="/fragments/header.jsp" %>
		
			<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                        
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Gestione Clienti</h3>
                            </div>
                         <div class="card-body">
		<%
		ArrayList<UtenteBean> utenti = (ArrayList<UtenteBean>) request.getAttribute("listaUtenti");
		if(utenti != null){
		%>
		<table>
			<tr>
				<thead>	
					<th>Email</th>
					<th>Tipo</th>
				</thead>
			</tr>
				<tbody>
					<%for (UtenteBean u : utenti) {%>
					<tr>
						<td><%=u.getEmail()%></td>
						<td><%=u.getTipo()%></td>
						<form method="post" action="/Progetto-HomeGym/AdminControl">
		                    <input type="hidden" name="utente" value="<%=u.getEmail()%>">
		                    <input type="hidden" name="action" value="ordiniUtente">
		                    <td><button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Ordini</button></td>
	                    </form>
		                <form method="post" action="/Progetto-HomeGym/AdminControl">
		                    <input type="hidden" name="utente" value="<%=u.getEmail()%>">
		                    <input type="hidden" name="action" value="feedbackUtente">
		                    <td><button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Feedback</button></td>
	                    </form>
                    </tr>
                    <%} %>
				</tbody>	
		</table>
		<%} %>
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