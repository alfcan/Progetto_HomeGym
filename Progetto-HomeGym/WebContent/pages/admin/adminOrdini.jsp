<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList, java.text.SimpleDateFormat" %>

<%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>

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
		
		<h1 style="text-align: center;color: #FA9600;font-family:Verdana;">Gestione Ordini</h1>
		<div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
		<form method="post" action="/Progetto-HomeGym/AdminControl">
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
          <div class="card-header carta1">
              <h3 class="mb-0">Effettuare ricerca per data:</h3>
          </div>
          <div class="card-body">
			<input type="hidden" name="action" value="viewOrdinePerData">
			<label>Da <input type="date" name="dataDa" required></label><br>
			<label>A <input type="date" name="dataA" required></label>
			<br>
			<button type="submit" class="btn btn-danger btn-lg float-right btn-mio">Invia</button>		
		</form>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		
		<hr>
		<%
		ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");
		if(ordini != null){
		%>
		<div class="card rounded-0 CDtot" id="contenitoreTotale">
          
		<table>
			<tr>
				<thead>	
					<th>Codice</th>
					<th>Stato</th>
					<th>Data</th>
					<th>Utente</th>
				</thead>
			</tr>
				<tbody>
					<%for (OrdineBean o : ordini) {
						String data = sdf.format(o.getData());
					%>
					<tr>
						<td><%=o.getID()%></td>
						<td><%=o.getStato()%></td>
						<td><%=data%></td>
						<td><%=o.getUtente()%></td>		
						<form method="post" action="/Progetto-HomeGym/AdminControl">
	                    <input type="hidden" name="idOrdine" value="<%=o.getID()%>">
	                    <input type="hidden" name="action" value="viewOrdine">
	                    <td><button type="submit" class="btn btn-danger btn-lg float-right btn-mio">Vai all'ordine</button></td>
	                    </form>
                    </tr>
                    <%} %>
				</tbody>	
		</table>
		</div>
		</div>
		<%} %>
		
		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>