<%@page import="controlador.AgregarCancionLista"%>
<%@page import="pojo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.Cancion"%>
<%@ page import="pojo.ListaReproduccion"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
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
			String crearCancion = "CrearCancion";
			String inicio = "Principal";
			String editarAlbum = "EditarAlbum";
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
			String editarCancion = "EditarCancion";
			String eliminarArtista = "EliminarArtista";
			String eliminarAlbum = "EliminarAlbum";
			String eliminarCancion = "EliminarCancion";
			String agregarCancionLista = "AgregarCancionLista";
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
			String editarCancion = "EditarCancion";
=======
<<<<<<< HEAD
			String editarCancion = "EditarCancion";
=======
>>>>>>> master
>>>>>>> master
			String eliminarArtista = "EliminarArtista";
			String eliminarAlbum = "EliminarAlbum";
			String eliminarCancion = "EliminarCancion";
>>>>>>> master
>>>>>>> master
>>>>>>> master
			Usuario usuario = (Usuario) request.getAttribute("usuario");

			Album album = (Album) request.getAttribute("album");

			ArrayList<Cancion> canciones = (ArrayList<Cancion>) request.getAttribute("canciones");
<<<<<<< HEAD

			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

=======
<<<<<<< HEAD

			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

=======
<<<<<<< HEAD

			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

=======
>>>>>>> master
>>>>>>> master
>>>>>>> master
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearCancion + "?id=" + album.getId()
							+ "'>Crear cancion</a> | <a href='" + editarAlbum + "?id=" + +album.getId()
							+ "'>Editar album</a> | <a href='" + eliminarAlbum + "?id=" + album.getId()
							+ "'><Eliminar album</a> | <a href='" + inicio + "'>Inicio</a>");
				} else {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + baja
							+ "'>Eliminar cuenta</a> | <a href='" + inicio + "'>Inicio</a>");
				}
			} else {
				out.println("<img src='Imatges/sinImagen.jsp'><br>");
				out.print("<a href='" + login + "'>Login</a>");
				out.print("| <a href='" + registrar + "'>Registrar</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<%
		out.println("<h2>" + album.getNombre() + "</h2>");
		out.println(album.getAnyo());
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master

		for (Cancion c : canciones) {
			if (usuario.getAdministrador() != 1) {
				out.println("<p>" + c.getTitulo() + " | <a href='" + eliminarCancion + "?id=" + c.getId()
						+ "'>Eliminar Cancion</a> | <a href='" + editarCancion + "?id=" + c.getId()
						+ "'>Editar Cancion</a></p>");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
				out.print("<div class='dropdown'>"
						+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
						+ "<span class='caret'></span></button>" + "<ul class='dropdown-menu'>");
				for (ListaReproduccion l : listas) {
					out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
							+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
				}
				out.print("</ul></div>");
<<<<<<< HEAD
=======
=======
>>>>>>> master
>>>>>>> master

			} else {
				out.println("<p>" + c.getTitulo() + "</p>");
				out.print("<div class='dropdown'>"
						+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
						+ "<span class='caret'></span></button>" + "<ul class='dropdown-menu'>");
				for (ListaReproduccion l : listas) {
					out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
							+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
				}
				out.print("</ul></div>");
			}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
		if(usuario.getAdministrador() != 1){
			
		}
		for (Cancion c : canciones) {
			out.println("<p>" +c.getTitulo() + " | <a href='" + eliminarCancion + "?id=" + c.getId()
<<<<<<< HEAD
					+ "'>Eliminar Cancion</a> | <a href='" + editarCancion +"?id=" +c.getId() +"'>Editar Cancion</a></p>");
=======
<<<<<<< HEAD
					+ "'>Eliminar Cancion</a> | <a href='" + editarCancion +"?id=" +c.getId() +"'>Editar Cancion</a></p>");
=======
					+ "'>EliminarCancion</a></p>");
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master

		}
	%>
</body>
</html>