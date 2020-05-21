<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear artista</title>
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
			if (usuario != null) {
				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>

	<form method="post" action="CrearArtista" enctype="multipart/form-data">
		<p>Nombre del artista o del grupo</p>
		<input type="text" name="nombre"> <br>
		<p>Foto del artista o del grupo</p>
		<input type="file" name="foto"><br> <input type="submit"
			value="Insertar">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
</body>
</html>