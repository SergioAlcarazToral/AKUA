<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear genero para canciones</title>
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
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			String logout = "Logout";
			String inicio = "Principal";
			String baja = "DarDeBaja";

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a>");
				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			}
		%>
	</div>
	<h2 id='h2Intro'>Crear lista</h2>
	<form id="formRegistrar" method="post" action="CrearLista">
		<p>Nombre de la lista de reproduccion</p>
		<input type="text" name="nombre" required>
		<%
			out.print("<input type='hidden' value='" + usuario.getId() + "' name='id'>");
		%>
		<br /> <br /> <input type="submit" value="Crear lista">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 |
		Contacto: akuaProyect@gmail.com</footer>

</body>
</html>