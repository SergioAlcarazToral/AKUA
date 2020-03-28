<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Album"%>
<%@ page import="pojo.Cancion"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			String eliminarArtista = "EliminarArtista";

			Usuario usuario = (Usuario) request.getAttribute("usuario");

			Album album = (Album) request.getAttribute("album");

			ArrayList<Cancion> canciones= (ArrayList<Cancion>) request.getAttribute("canciones");
			if (usuario != null) {
				if (usuario.getAdministrador() != 1) {
					out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
					out.print("<p>" + usuario.getNombre() + "</p>");
					out.print("<a href='" + logout + "'>Logout</a> | <a href='" + crearCancion + "?id=" + album.getId()
							+ "'>Crear cancion</a> | <a href='" + inicio + "'>Inicio</a>");
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
		for(Cancion c : canciones){
			out.println(c.getTitulo());
		}
	%>
</body>
</html>