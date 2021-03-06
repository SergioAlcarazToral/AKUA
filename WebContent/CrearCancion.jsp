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
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			Album album = (Album) request.getAttribute("idAlbum");
			ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");

			String logout = "Logout";
			String inicio = "Principal";

			if (usuario != null) {
				out.print("<img id='fotoUser' src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a>");
			}
		%>
	</div>
	<form id="formCancion" action="CrearCancion" method="post"
		enctype="multipart/form-data">
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
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 |
		Contacto: akuaProyect@gmail.com</footer>

</body>
</html>