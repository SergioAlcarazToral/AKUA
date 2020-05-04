<%@page import="controlador.AgregarCancionLista"%>
<%@page import="pojo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.Cancion"%>
<%@ page import="pojo.Genero"%>
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
<title>Canciones recomendadas por genero</title>
<script type="text/javascript">

function sonar(){
	audio.stop();
	audio.play();
}

</script>
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
			String inicio = "Principal";
			String agregarCancionLista = "AgregarCancionLista";
			Usuario usuario = (Usuario) request.getAttribute("usuario");


			ArrayList<Cancion> canciones = (ArrayList<Cancion>) request.getAttribute("canciones");

			Genero genero = (Genero) request.getAttribute("genero");
			
			ArrayList<ListaReproduccion> listas = (ArrayList<ListaReproduccion>) request.getAttribute("listas");

			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + inicio + "'>Inicio</a>");
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
		out.println("<h2>" + genero.getNombre() + "</h2>");

		for (Cancion c : canciones) {
			if (usuario != null) {
				out.println("<p>" + c.getTitulo() + "</p><audio src='ArchivosMusica/" + c.getArchivo() + "'  preload='metadata' controls></audio>");
				out.print("<div class='dropdown'>"
						+ "<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Añadir a lista"
						+ "<span class='caret'></span></button>" + "<ul class='dropdown-menu'>");
				for (ListaReproduccion l : listas) {
					out.print("<li><a href='" + agregarCancionLista + "?nombre=" + l.getNombre() + "&idUsuario="
							+ usuario.getId() + "&idCancion=" + c.getId() + "'>" + l.getNombre() + "</a></li>");
				}
				out.print("</ul></div>");

			} else {
				out.println("<p>" + c.getTitulo() + "</p><audio src='ArchivosMusica/" + c.getArchivo() + "'  preload='metadata' controls></audio>");
				out.print("</ul></div>");
			}

		}
	%>
</body>
</html>