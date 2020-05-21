<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel='stylesheet' type='text/css' href='css.css'>

</head>
<body>
<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
		<h1 id="akua">LOGIN</h1>
	</div>
	<form id='formLogin' method="post" action="Login">
		<p>Email del usuario:</p>
		<input type="email" name="correo">
		<p>Password:</p>
		<input type="password" name="pass"> <br> <br> <input
			type="submit" value="Login">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
	<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
			out.print("Hay errores a la hora de iniciar sesion, por favor intentelo mas tarde");
		}
	%>
</body>
</html>