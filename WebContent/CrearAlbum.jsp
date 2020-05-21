<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Artista"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear un album</title>
<link rel='stylesheet' type='text/css' href='css.css'>
</head>
<body>
	<div id="divLogo">
		<a href="Principal"><img id="Logo" src="icons/akua negro.png"></a>
	</div>
	<div id="cajaUsuario">
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");

			if (usuario != null) {
				String logout = "Logout";

				out.print("<img src='Imatges/" + usuario.getFoto() + "'><br>");
				out.print("<p>" + usuario.getNombre() + "</p>");
				out.print("<a href='" + logout + "'>Logout</a>");

			}
			Artista idArtista = (Artista) request.getAttribute("idArtista");
		%>
	</div>
	<form action="CrearAlbum" method="post" enctype="multipart/form-data">
		<p>Nombre del album:</p>
		<input type="text" name="nombre" required>
		<p>Año del album</p>
		<input type="number" name="anyo" required>
		<%
			out.print("<input type='hidden'value=" + idArtista.getId() + " name='idArtista'>");
		%>
		<p>
			Foto del album <input type="file" name="foto"> <br> <input
				type="submit" value="Crear album">
	</form>
</body>
</html>