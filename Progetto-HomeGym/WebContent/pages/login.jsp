<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>HomeGym - Login</title>
	</head>
	<body>
		<form action="Login" method="post">
			<fieldset>
			     <legend>Login</legend>
			     <label for="username">Login</label>
			     <input id="username" type="text" name="username" placeholder="Nome Utente"> 
			     <br>   
			     <label for="password">Password</label>
			     <input id="password" type="password" name="password" placeholder="Password"> 
			     <br>
			     <input type="submit" value="Login"/>
			     <input type="reset" value="Reset"/>
			</fieldset>
		</form> 
	</body>
</html>
