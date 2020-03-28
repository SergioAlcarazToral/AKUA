<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AKUA</title>
</head>
<body>
	<div id="divLogo">
		<img id="Logo" src="">
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String crearArtista = "CrearArtista";
			String crearGenero = "CrearGenero";
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print(
							"<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista + "'>Añadir Artista</a> | <a href='" + crearGenero + "'>Crear genero</a>");
				} else {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			} else {
				out.println("<img src='Imatges/sinImagen.jsp'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print("| <a href='" + registrar + "'>Registrar</a>");
			}
		%>
	</div>
	<form method="get" action="Buscar">
		<p>Busca tus canciones y artistas favoritos</p>
		<input type="text" name="buscar">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
</body>
</html>