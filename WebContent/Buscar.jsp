<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Artista"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AKUA</title>
<link rel='stylesheet' type='text/css' href='css.css'>

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
			String crearArtista = "CrearArtista";
			String inicio = "Principal";
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista + "'>Añadir Artista</a>");
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
	<h1 id="resultBus">Resultado de la busqueda</h1>
	<h2>Artistas</h2>
	<%
		ArrayList<Artista> artistas = (ArrayList) request.getAttribute("artistas");

		for (Artista a : artistas) {
			out.print("<a class='resultArt' href='PaginaArtista?id=" + a.getId() +"'><img class='fotoArtista' src='ImgArtistas/" + a.getFoto() + "'><p>" + a.getNombre() + "</p></a>");
		}
	%>
	<h2>Albums</h2>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020</footer>
</body>
</html>