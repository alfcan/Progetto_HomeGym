<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.model.beans.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href=<%=request.getContextPath() + "/Stili/registrazione.css" %>>
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
                                <h3 class="mb-0">Feedback Utente</h3>
                            </div>
                            <div class="card-body">
		
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