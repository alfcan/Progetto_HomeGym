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
		
		<h1>FeedBack Utente</h1>
		<%
		ArrayList<FeedbackBean> feedbacks = (ArrayList<FeedbackBean>) request.getAttribute("feedbackUtente");
		if(feedbacks != null && !feedbacks.isEmpty()){
		%>
		<table>
			<tr>
				<thead>	
					<th>Valutazione</th>
					<th>Commento</th>
					<th>Codice Prodotto</th>
				</thead>
			</tr>
				<tbody>
					<%for (FeedbackBean f : feedbacks) {%>
					<tr>
						<td><%=f.getValutazione()%></td>
						<td><%=f.getCommento()%></td>
						<td><%=f.getProdotto()%></td>
					</tr>
                    <%} %>
				</tbody>	
		</table>
		<%} else { %>
			<h6>L'utente non ha rilasciato feedback.</h6>
		<%} %>
		
		<%@ include file="/fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>