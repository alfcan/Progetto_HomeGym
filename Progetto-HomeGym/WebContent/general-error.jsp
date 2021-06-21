<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="icon" href="<%=request.getContextPath() + "foto/logofavicon.png"%>" sizes="9x9">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/css/bootstrap.min.css"%>">	
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/header.css"%>">
		<link rel="stylesheet" href="<%=request.getContextPath() + "/Stili/footer.css"%>">
		<script src="<%=request.getContextPath() + "/jsMiei/footer.js"%>"></script>
		<meta charset="ISO-8859-1">
		<title>HomeGym - Error Page</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<h3 style="text-align: center;color: #FA9600;font-family:Verdana;padding-top:30px;">Ci scusiamo per il disagio. C'è stato un errore, ritorna alla nostra <a href="/Progetto-HomeGym/index.jsp">Home Page</a></h3>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>