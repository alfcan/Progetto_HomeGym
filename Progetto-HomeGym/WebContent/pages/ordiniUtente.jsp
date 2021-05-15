<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.unisa.model.DAOS.*, it.unisa.model.beans.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Ordini</title>
	</head>
	<body>
	
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		
		<h1>I tuoi ordini</h1>
		
		<% 
			ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");
			if(ordini != null){
		%>	
		<table>
			<tr>
				<th>ID Ordine</th>
				<th>Stato</th>
				<th>Indirizzo Spedizione</th>
				<th>Totale</th>
			</tr>
			<%for(OrdineBean ordine : ordini){ %>
				<tr>
					<th><%=ordine.getID()%></th>
					<th><%=ordine.getStato()%></th>
					<th><%=ordine.getIndirizzoSpedizione()%></th>
					<th>
						<a href="OrdineControl?action=dettagliOrdine&id=<%=ordine.getID()%>">Dettagli</a>
					</th>
				<tr>		
			<%	}
			%>
			</table>
			<%
			} else { %>
				<h3>Non hai effettuato ordini</h3>
			<%} %>
			
		<%@ include file="../fragments/footer.jsp" %>
	</body>
</html>