<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Artista"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina del artista</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='css.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			String login = "Login";
			String registrar = "Registrar";
			String logout = "Logout";
			String baja = "DarDeBaja";
			String crearAlbum = "CrearAlbum";
			String inicio = "Principal";
			String eliminarArtista = "EliminarArtista";
			String paginaAlbum = "PaginaAlbum";

			Usuario usuario = (Usuario) request.getAttribute("usuario");
			Artista artista = (Artista) request.getAttribute("artista");
			ArrayList<Album> albumes = (ArrayList<Album>) request.getAttribute("albumes");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearAlbum + "?id=" + artista.getId()
							+ "'>Añadir album</a> | <a href='" + eliminarArtista + "?id=" + artista.getId()
							+ "'>Eliminar artista</a> | <a href='" + inicio + "'>Inicio</a>");
				} else {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja
							+ "'>Eliminar cuenta</a> | <a href='" + inicio + "'>Inicio</a>");
				}
			} else {
				out.println("<img id='fotoUser' src='Imatges/sinImagen.jsp'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print(" | <a href='" + registrar + "'>Registrar</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<%
		out.print("<h2 id='h2Intro'>" + artista.getNombre() + "</h2>");
		out.print("<h3>Albumes del artista</h3>");
		for (Album a : albumes) {
			out.println("<a class='resultAlbum' href='" + paginaAlbum + "?id=" + artista.getId() + "'><img class='fotoAlbum' src='ImgAlbums/"
					+ a.getFoto() + "'><p>" + a.getNombre() + "</p></a>");
		}
	%>
</body>
</html>