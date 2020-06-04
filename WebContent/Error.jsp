<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.ListaReproduccion"%>
<%@ page import="pojo.Genero"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' type='text/css' href='css.css'>
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Hind+Madurai:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
		<h1 id="akua">AKUA</h1>
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String crearArtista = "CrearArtista";
			String crearGenero = "CrearGenero";
			String crearLista = "CrearLista";

			Usuario usuario = (Usuario) request.getAttribute("usuario");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista
							+ "'>Añadir Artista</a> | <a href='" + crearLista + "'>Crear lista</a> | <a href='"
							+ crearGenero + "'>Crear genero</a>");

				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearLista
							+ "'>Crear lista</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			} else {
				out.println("<img  id='fotoUser' src='Imatges/sinImagen.jpg'><br>");
				out.print("<a href='" + login + "'>Login</a> | ");
				out.print("<a href='" + registrar + "'>Registrar</a>");
			}
		%>
	</div>
	<div>
		<%
			out.print(
					"<h2 id='h2Error'>Lo sentimos, ha ocurrido un error inesperado, por favor intentelo mas tarde</h2>");
		%>
	</div>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 |
		Contacto: akuaProyect@gmail.com</footer>
</body>
</html>