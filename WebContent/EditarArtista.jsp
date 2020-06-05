<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Artista"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar un album</title>
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
<link rel='stylesheet' type='text/css' href='css.css'></head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");

			if (usuario != null) {
				String logout = "Logout";

				out.print("<img id='fotoUser'src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a>");

			}
			Artista artista = (Artista) request.getAttribute("artista");
		%>
	</div>
	<form id='formArtista' action="EditarArtista" method="post"
		enctype="multipart/form-data">
		<%
			out.print("<p>Nombre del artista:</p>");
			out.print("<input type='text' name='nombre' value='" + artista.getNombre() + "' required>");

			out.print("<p>Foto del artista</p>");
			out.print("<input type='file' name='foto'>");

			out.print("<input type='hidden' name='id' value='" + artista.getId() + "'>");
		%>
		<br/>
		<br/>
		<input type="submit" value="Editar artista">
	</form>
	<footer>Web creada por: Sergio Alcaraz Toral copyright:2020 | Contacto: akuaProyect@gmail.com</footer>
</body>
</html>