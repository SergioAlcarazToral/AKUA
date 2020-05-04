<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Genero"%>
<%@ page import="pojo.Album"%>

<%@ page import="java.util.ArrayList"%>

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
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			Album album = (Album) request.getAttribute("idAlbum");
			ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");

			String logout = "Logout";
			String inicio = "Principal";

			if (usuario != null) {
				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a> | <a href='" + inicio + "'>Inicio</a>");
			}
		%>
	</div>
	<form action="CrearCancion" method="post" enctype="multipart/form-data">
		<p>Titulo de la cancion</p>
		<input type="text" name="titulo">
		<p>Genero</p>
		<select name="genero">
			<%
				for (Genero g : generos) {
					out.print("<option value='" + g.getId() + "'>" + g.getNombre() + "</option>");
				}
			%>
		</select>
		<%
			out.print("<input type='hidden' value='" + album.getId() + "' name='idAlbum'>");
		%>
		<p>Archivo de audio</p>
		<input type="file" name="archivo" required><br> <input
			type="submit" value="Insertar cancion">
	</form>
</body>
</html>