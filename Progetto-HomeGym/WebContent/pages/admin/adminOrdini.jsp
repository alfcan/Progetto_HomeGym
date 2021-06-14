<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body>
		<%@ include file="/fragments/header.jsp" %>
		
		<h1>Gestione Ordini</h1>
		<form method="post" action="/Progetto-HomeGym/AdminControl">
			<p>Effetuare ricerca per data:</p>
			<input type="hidden" name="action" value="viewOrdinePerData">
			<label>Da <input type="date" name="dataDa" required></label><br>
			<label>A <input type="date" name="dataA" required></label>
			<br>
			<button type="submit">Invia</button>		
		</form>
		<hr>
		<%
		ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");
		if(ordini != null){
		%>
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
					<%for (OrdineBean o : ordini) {%>
					<tr>
						<td><%=o.getID()%></td>
						<td><%=o.getStato()%></td>
						<td><%=o.getData()%></td>
						<td><%=o.getUtente()%></td>		
						<form method="post" action="/Progetto-HomeGym/AdminControl">
	                    <input type="hidden" name="idOrdine" value="<%=o.getID()%>">
	                    <input type="hidden" name="action" value="viewOrdine">
	                    <td><button type="submit">Vai all'ordine</button></td>
	                    </form>
                    </tr>
                    <%} %>
				</tbody>	
		</table>
		<%} %>
		
		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>