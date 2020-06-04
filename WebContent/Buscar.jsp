<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Artista"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.CancionCompleta"%>
<%@ page import="pojo.ListaReproduccion"%>
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
<script>
	function longitud(){
		document.getElementById("lRepro").style.height = document.body.scrollHeight + "px";
	}
</script>
</head>
<body onload="longitud()">
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String crearArtista = "CrearArtista";
			String crearLista = "CrearLista";
			String inicio = "Principal";
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print(
							"<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista + "'>Añadir Artista</a>");
				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
				}
			} else {
				out.println("<img id='fotoUser' src='Imatges/sinImagen.jpg'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print("| <a href='" + registrar + "'>Registrar</a>");
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
		<h1 id="resultBus">Resultado de la busqueda</h1>
		<h2>Artistas</h2>
		<%
			ArrayList<Artista> artistas = (ArrayList) request.getAttribute("artistas");

			for (Artista a : artistas) {
				out.print("<a class='resultArt' href='PaginaArtista?id=" + a.getId()
						+ "'><img class='fotoArtista' src='ImgArtistas/" + a.getFoto() + "'><p>" + a.getNombre()
						+ "</p></a>");
			}
		%>
		<h2>Albums</h2>

		<%
			ArrayList<Album> albums = (ArrayList) request.getAttribute("albums");
			for (Album al : albums) {
				out.print("<a class='resultArt' href='PaginaAlbum?id=" + al.getId()
						+ "'><img class='fotoArtista' src='ImgAlbums/" + al.getFoto() + "'><p>" + al.getNombre()
						+ "</p></a>");
			}
		%>
		<h2>Canciones</h2>
		<%
			ArrayList<CancionCompleta> canciones = (ArrayList) request.getAttribute("canciones");
			for (CancionCompleta c : canciones) {
				out.print("<a class='resultArt' href='PaginaAlbum?id=" + c.getIdAlbum()
						+ "'><img class='fotoArtista' src='ImgAlbums/" + c.getAlbum() + "'><p>" + c.getTitulo()
						+ "</p></a>");
			}
		%>
	</div>
</body>
</html>