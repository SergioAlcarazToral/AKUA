<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.ListaReproduccion"%>

<%@ page import="java.util.ArrayList"%>

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
			String crearLista = "CrearLista";
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearArtista
							+ "'>Añadir Artista</a> | <a href='" + crearLista + "'>Crear lista</a> | <a href='"
							+ crearGenero + "'>Crear genero</a>");
					for (ListaReproduccion lista : listas) {
						out.print("<p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre=" + lista.getNombre()
								+ "'>" + lista.getNombre() + "</a></p>");
					}

				} else {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearLista
							+ "'>Crear lista</a> | <a href='" + baja + "'>Eliminar cuenta</a>");
					for (ListaReproduccion lista : listas) {
<<<<<<< HEAD
						out.print("<p><a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre=" + lista.getNombre()
								+ "'>" + lista.getNombre() + "</a></p>");
=======
						out.print("<a href='PaginaLista?idUsuario=" + usuario.getId() + "&nombre=" + lista.getNombre()
								+ "'>" + lista.getNombre() + "</a>");
>>>>>>> master
					}
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