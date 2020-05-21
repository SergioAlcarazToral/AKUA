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
<title>AKUA</title>
<link rel='stylesheet' type='text/css' href='css.css'>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Hind+Madurai:wght@300&display=swap" rel="stylesheet"> 
<script type="text/javascript">
	function playMusic() {
		audio.pause();
		audio.play();
	}
</script>
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
							+ "'>Añadir Artista</a> | <a href='" + crearLista + "'>Crear lista</a> | <a href='"
							+ crearGenero + "'>Crear genero</a>");
					for (ListaReproduccion lista : listas) {
						out.print("<div id='lRepro'><p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre="
								+ lista.getNombre() + "'>" + lista.getNombre() + "</a></p></div>");
					}

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
	<%
		if(usuario != null){
			out.print("<div id='lRepro'><h2 id='h2Intro'>Listas</h2>");
			for (ListaReproduccion lista : listas) {
				out.print("<p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre="
						+ lista.getNombre() + "'>" + lista.getNombre() + "</a></p>");
			}
			out.print("</div>");
		}
	%>
	<form id="buscar" method="get" action="Buscar">
		<h3>Busca tus canciones y artistas favoritos</h3>
		<input type="text" name="buscar">
	</form>
	<h2 id="recomCancion">Canciones recomendadas por genero</h2><br/><br/>
	<%
		ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");
		out.print("<div id='generos'>");
		for (Genero g : generos) {
			out.println("<h2><a class='allGeneros' href='RecomGenero?nombre=" + g.getNombre() + "'>" + g.getNombre() + "</a></h2>");
		}
		out.print("</div>");
	%>

	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
</body>
</html>