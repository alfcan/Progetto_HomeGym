<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>

<%
	UtenteBean utente = (UtenteBean) request.getSession().getAttribute("Utente");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Area Utente</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		<h1>Benvenuto nella tua area utente</h1>
		<%
		if(utente == null){	
			response.sendRedirect("login.jsp");
		}else{
		%>
			<ul>
				<li><a href="OrdineControl?email=<%=utente.getEmail()%>">I miei ordini</a></li>
			</ul>
		<%
		}
		%>
	</body>
	
	<%@ include file="../fragments/footer.jsp" %>
</html>