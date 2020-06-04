<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar un usuario</title>
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Hind+Madurai:wght@300&display=swap"
	rel="stylesheet">
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='css.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel='stylesheet' type='text/css' href='css.css'>
</head>
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
		<h1 id="akua">PAGINA DE REGISTRO</h1>
	</div>
	<h1>Formulario de registro</h1>
	<hr>
	<form id="formRegistrar"action="Registrar" method="post" enctype="multipart/form-data">
		<p>Nombre</p>
		<input type="text" name="nombre" required>
		<p>Correo</p>
		<input type="email" name="correo" required>
		<p>Contraseña</p>
		<input type="password" name="pass" required>
		<p>Foto</p>
		<input type="file" name="foto"><br><br>
		<input type="submit"
			value="Registrar">
	</form>
		<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
</body>
</html>