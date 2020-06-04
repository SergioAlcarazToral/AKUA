<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.ListaReproduccion"%>
<%@ page import="pojo.Genero"%>
<%@ page import="pojo.Artista"%>

<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AKUA</title>
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
			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista
							+ "'>Añadir Artista</a> | <a href='" + crearGenero + "'>Crear genero</a>");

				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			} else {
				out.println("<img  id='fotoUser' src='Imatges/sinImagen.jpg'><br>");
				out.print("<a href='" + login + "'>Login</a> | ");
				out.print("<a href='" + registrar + "'>Registrar</a>");
			}
		%>
	</div>
	<%
		if (usuario != null) {
			out.print("<div id='lRepro'><h2 id='h2Intro'>Listas</h2>");
			out.print("<p><a href='" + crearLista + "'>Crear lista</a></p>");
			out.print("<hr/>");
			for (ListaReproduccion lista : listas) {
				out.print("<p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre=" + lista.getNombre()
						+ "'>" + lista.getNombre() + "</a></p>");
			}
			out.print("</div>");
		}
	%>
	<div class="container">
	<form id="buscar" method="get" action="Buscar">
		<h3>Busca tus canciones y artistas favoritos</h3>
		<input type="text" name="buscar">
	</form>
	<h2 id="recomCancion">Canciones recomendadas por género</h2>
	<br />
	<br />
	<%
		ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");
		out.print("<div id='generos'>");
		for (Genero g : generos) {
			out.println("<h2><a class='allGeneros' href='RecomGenero?nombre=" + g.getNombre() + "'>" + g.getNombre()
					+ "</a></h2>");
		}
		out.print("</div>");
	%>
	<br />
	<br />
	<%
		if (usuario != null) {
			out.print("<h2 id='recomArtistas'>Artistas recomendados</h2>");
			out.print("<div id='divrecomArtistas'>");
			ArrayList<Artista> artistas = (ArrayList<Artista>) request.getAttribute("artistas");
			for (Artista a : artistas) {
				out.println("<a class='resultArt' href='PaginaArtista?id=" + a.getId()
						+ "'><img class='fotoArtista' src='ImgArtistas/" + a.getFoto() + "'><p>" + a.getNombre()
						+ "</p></a>");

			}
			out.print("</div>");
		}
	%>
</div>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 | Contacto: akuaProyect@gmail.com</footer>
</body>
</html>