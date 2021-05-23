<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>HomeGym - Login</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		
		<form action="/Progetto-HomeGym/Login" method="post">
			<fieldset>
			     <legend>Login</legend>
			     <label for="email">Email</label>
			     <input id="email" type="text" name="email" placeholder="Email"> 
			     <br>   
			     <label for="password">Password</label>
			     <input id="password" type="password" name="password" placeholder="Password"> 
			     <br>
			     <input type="submit" value="Login"/>
			     <input type="reset" value="Reset"/>
			</fieldset>
		</form>
		
		<a href="registerPersonaFisica.jsp">Non hai un account? Registrati qui.</a> <br>
		<a href="registerAzienda.jsp">Sei un'azienda e non sei ancora registrata? Registarti qui.</a>
		
		<%@ include file="../fragments/footer.jsp" %>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>
