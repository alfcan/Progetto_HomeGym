<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HomeGym</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		
		<%String operazione = (String) request.getAttribute("operazione"); %>		
		<h3><%=operazione %></h3>
		
		<%@ include file="/fragments/footer.jsp" %>
	</body>
</html>