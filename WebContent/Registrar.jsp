<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar un usuario</title>
<link rel='stylesheet' type='text/css' href='css.css'>
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
		<h1 id="akua">AKUA</h1>
	</div>
	<h1>Formulario de registro</h1>
	<hr>
	<form id="formRegistrar"action="Registrar" method="post" enctype="multipart/form-data">
		<p>Nombre</p>
		<input type="text" name="nombre">
		<p>Correo</p>
		<input type="email" name="correo">
		<p>Contraseña</p>
		<input type="password" name="pass">
		<p>Foto</p>
		<input type="file" name="foto"><br><br>
		<input type="submit"
			value="Registrar">
	</form>
</body>
</html>