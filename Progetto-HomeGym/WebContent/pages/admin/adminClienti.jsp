<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Amministratore</title>
	</head>
	<body>
		<%@ include file="/fragments/header.jsp" %>
		<%@ include file="/fragments/menu.jsp" %>
		<h1>Gestione Clienti</h1>		
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
	                    <td><button type="submit">I suoi ordini</button></td>
	                    </form>
                    </tr>
                    <%} %>
				</tbody>	
		</table>
		<%} %>
		
		<%@ include file="/fragments/footer.jsp" %>
	</body>
</html>