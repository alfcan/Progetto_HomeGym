<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">	
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
		<meta charset="ISO-8859-1">
		<title>HomeGym</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<%String operazione = (String) request.getAttribute("operazione"); %>	
		<h3 style="text-align: center;color: #FA9600;font-family:Verdana;padding-top:30px;"><%=operazione %></h3>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>