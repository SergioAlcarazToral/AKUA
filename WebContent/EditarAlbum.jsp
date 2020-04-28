<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Usuario"%>
<%@ page import="pojo.Album"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar un album</title>
</head>
<body>
	<div id="divLogo">
		<img id="Logo" src="">
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
			Album album = (Album) request.getAttribute("album");
		%>
	</div>
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
>>>>>>> master
	<form action="EditarAlbum" method="post" enctype="multipart/form-data">
		<%
			out.print("<p>Nombre del album:</p>");
			out.print("<input type='text' name='nombre' value='" + album.getNombre() + "' required>");

			out.print("	<p>Año del album</p>");
			out.print("<input type='number' name='anyo' value='" + album.getAnyo() + "'  required>");

			out.print("<p>Foto del album</p>");
			out.print("<input type='file' name='foto'>");
			
			out.print("<input type='hidden' name='id' value='" + album.getId() + "'>");
		%>

		<input type="submit" value="Editar album">
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
	<form action="EditarCancion" method="post" enctype="multipart/form-data">
		<p>Nombre del album:</p>
		<%out.print("<input type='text' name='nombre' value='" +album.getNombre() + "' required>");%>
		<p>Año del album</p>
		<%out.print("<input type='number' name='anyo' value='" + album.getAnyo() +"'  required>");%>
		<p>
			Foto del album <input type="file" name="foto"> <br> <input
				type="submit" value="Crear album">
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
	</form>
</body>
</html>