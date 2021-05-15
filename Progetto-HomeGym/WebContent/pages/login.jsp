<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>HomeGym - Login</title>
	</head>
	<body>
		<%@ include file="../fragments/header.jsp" %>
		<%@ include file="../fragments/menu.jsp" %>
		
		<%
			String isNotValidLogin = (String) request.getAttribute("isNotValidLogin");
			if(isNotValidLogin != null){
		%>
				<h5>Email o password non corretta</h1>
		<%
			}
		%>
		
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
	</body>
</html>
