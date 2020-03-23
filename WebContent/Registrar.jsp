<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar un usuario</title>
</head>
<body>
	<h1>Formulario de registro</h1>
	<hr>
	<form action="Registrar" method="post">
		<p>Nombre</p>
		<input type="text" name="nombre">
		<p>Correo</p>
		<input type="email" name="correo">
		<p>Contraseña</p>
		<input type="password" name="pass">
		<p>Foto</p>
		<input type="file" name="foto"> <input type="submit"
			value="Registrar">
	</form>
</body>
</html>